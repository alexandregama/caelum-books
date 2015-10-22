package br.com.caelum.livraria.cart;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.caelum.livraria.jms.EnviadorMensagemJms;
import br.com.caelum.livraria.modelo.BookFormat;
import br.com.caelum.livraria.modelo.ItemCompra;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.modelo.Pagamento;
import br.com.caelum.livraria.modelo.Pedido;
import br.com.caelum.livraria.modelo.Transacao;
import br.com.caelum.livraria.rest.ClienteRest;

@Component
@Scope("session")
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	private Set<ItemCompra> itensDeCompra = new LinkedHashSet<>();
	private BigDecimal valorFrete = BigDecimal.ZERO;
	private String cepDestino;
	private Pagamento pagamento;

	@Autowired
	private ClienteRest clienteRest;

	@Autowired
	private EnviadorMensagemJms enviador;

	public void add(Livro book, BookFormat bookFormat) {
		ItemCompra item = new ItemCompra(book, bookFormat);

		if (itemExistsInCart(item)) {
			ItemCompra itemCarrinho = this.searchItem(item);
			itemCarrinho.increaseQuantity(item.getQuantidade());
		} else {
			this.itensDeCompra.add(item);
		}

		updatePayment();
	}

	public void removeBookBy(String codigo, BookFormat bookFormat) {

		ItemCompra itemARemover = procurarItemPelaId(codigo, bookFormat);

		if (itemARemover != null) {
			this.itensDeCompra.remove(itemARemover);
		}

		if (!this.isComLivrosImpressos()) {
			this.valorFrete = BigDecimal.ZERO;
		}

		updatePayment();
	}

	public Pagamento createPayment(String numeroCartao, String nomeTitular) {
		Transacao transacao = new Transacao();
		transacao.setNumero(numeroCartao);
		transacao.setTitular(nomeTitular);
		transacao.setValor(this.getTotal());

		this.pagamento = this.clienteRest.criarPagamento(transacao);
		
		return this.pagamento;
	}

	private void updatePayment() {
		this.pagamento = null;
		//poderia ter chamada do WS para cancelar o pagamento
	}

	public Pedido finalizarPedido() {
		Pedido pedido = new Pedido();
		pedido.setData(Calendar.getInstance());
		pedido.setItens(new LinkedHashSet<>(this.itensDeCompra));

		this.pagamento = this.clienteRest.confirmarPagamento(pagamento);
		pedido.setPagamento(pagamento);
		this.enviador.enviar(pedido);

		this.limparCarrinho();

		return pedido;
	}

	public void updateShipping(final String novoCepDestino) {
		this.cepDestino = novoCepDestino;

		//servico web do correios aqui
	}

	public String getCepDestino() {
		return cepDestino;
	}

	public List<ItemCompra> getItensCompra() {
		return new ArrayList<ItemCompra>(this.itensDeCompra);
	}

	public BigDecimal getTotal() {

		BigDecimal total = BigDecimal.ZERO;

		for (ItemCompra item : this.itensDeCompra) {
			total = total.add(item.getTotal());
		}

		return total.add(valorFrete);
	}

	public Pagamento getPagamento() {
		return this.pagamento;
	}

	public BigDecimal getValorFrete() {
		return valorFrete;
	}

	public boolean isCalculatedShipping() {
		return !this.valorFrete.equals(BigDecimal.ZERO) || !this.isComLivrosImpressos();
	}

	public boolean isPaymentCreated() {
		if (this.pagamento == null) {
			return false;
		}
		return this.pagamento.ehCriado();
	}

	public boolean isProntoParaSerFinalizado() {
		return this.isCalculatedShipping() && this.isPaymentCreated();
	}

	public boolean isComLivrosImpressos() {

		for (ItemCompra itemCompra : this.itensDeCompra) {
			if (itemCompra.isImpresso()) {
				return true;
			}
		}
		return false;
	}

//	private void atualizarQuantidadeDisponivelDoItemCompra(final ItemEstoque itemEstoque) {
//		ItemCompra item = Iterables.find(this.itensDeCompra, new Predicate<ItemCompra>() {
//
//			@Override
//			public boolean apply(ItemCompra item) {
//				return item.temCodigo(itemEstoque.getCodigo());
//			}
//		});
//
//		item.setQuantidadeNoEstoque(itemEstoque.getQuantidade());
//	}

	private void limparCarrinho() {
		this.itensDeCompra = new LinkedHashSet<>();
		this.valorFrete = BigDecimal.ZERO;
	}

	private boolean itemExistsInCart(final ItemCompra item) {
		return this.itensDeCompra.contains(item);
	}

	private ItemCompra searchItem(final ItemCompra itemProcurado) {
		for (ItemCompra item : this.itensDeCompra) {
			if (item.equals(itemProcurado)) {
				return item;
			}
		}
		throw new IllegalStateException("Item não encontrado");
	}

	private ItemCompra procurarItemPelaId(final String codigo, BookFormat bookFormat) {

		for (ItemCompra item : this.itensDeCompra) {
			if (item.getCodigo().equals(codigo) && item.getBookFormat().equals(bookFormat)) {
				return item;
			}
		}

		return null;
	}

	@SuppressWarnings("unused")
	private List<String> getCodigosDosItensImpressos() {
		List<String> codigos = new ArrayList<>();

		for (ItemCompra item : this.itensDeCompra) {
			if (item.isImpresso())
				codigos.add(item.getCodigo());
		}
		return codigos;
	}

	
}
