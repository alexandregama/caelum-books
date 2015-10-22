package br.com.caelum.livraria.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.caelum.livraria.book.Books;
import br.com.caelum.livraria.modelo.Cart;
import br.com.caelum.livraria.modelo.BookFormat;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.modelo.Pedido;
import br.com.caelum.livraria.order.Orders;

@Controller
@RequestMapping("/carrinho")
@Scope("request")
public class CartController {

	private static final String JSP_CART_PAYMENT_CONFIRMATION = "carrinho/confirmarPagamento";
	private static final String JSP_CART_LIST_ALL = "carrinho/listar";

	private static final String REDIRECT_CART_LIST_ALL = "redirect:/carrinho/listar";
	private static final String REDIRECT_CART_PAYMENT_CONFIRMATION = "redirect:/carrinho/confirmarPagamento";

	@Autowired
	private Cart cart;

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private Orders orders;

	@Autowired
	private Books books;

	@RequestMapping("/adicionarItem")
	public String addItemToCart(@RequestParam("id") Integer livroId, @RequestParam("formatoLivro") BookFormat bookFormat) {
		Livro livro = books.findById(livroId);

		cart.add(livro, bookFormat);

		return REDIRECT_CART_LIST_ALL;
	}

	@RequestMapping("/removerItem")
	public String removeItemFromCart(@RequestParam("codigo") String codigo, @RequestParam("formato") BookFormat bookFormat, RedirectAttributes result) {
		this.cart.removeBookBy(codigo, bookFormat);

		result.addFlashAttribute("messageInfo", "O item foi removido com sucesso.");

		return REDIRECT_CART_LIST_ALL;
	}

	@RequestMapping("/calcularCep")
	public String calculateShipping(@RequestParam("cepDestino") String novoCepDestino) {

		this.cart.updateShipping(novoCepDestino);

		return REDIRECT_CART_LIST_ALL;
	}

	@RequestMapping("/criarPagamento")
	public String createPayment(@RequestParam("numeroCartao") String creditcardNumber,
			@RequestParam("titularCartao") String creditcardTitular, RedirectAttributes result) {

		if (ehStringVazia(creditcardNumber) || ehStringVazia(creditcardTitular)) {
			result.addFlashAttribute("messageWarn", "Por favor preenche os dados do cartão!");
			return REDIRECT_CART_LIST_ALL;
		}

		this.cart.createPayment(creditcardNumber, creditcardTitular);

		if (this.cart.isPaymentCreated()) {
			result.addFlashAttribute("messageInfo", "O seu pagamento foi criado! - Por favor confirme o pedido.");
		} else {
			result.addFlashAttribute("messageWarn", "Pagamento não foi criado!");
		}

		return REDIRECT_CART_PAYMENT_CONFIRMATION;
	}

	@RequestMapping("/confirmarPagamento")
	public String confirmarPagamento() {
		return JSP_CART_PAYMENT_CONFIRMATION;
	}

	private boolean ehStringVazia(String string) {
		return string == null || string.trim().isEmpty();
	}

	@RequestMapping("/finalizar")
	@Transactional
	public String finishOrder(RedirectAttributes result) {

		if (!cart.isCalculatedShipping()) {
			result.addFlashAttribute("messageWarn", "O Frete deve ser calculado.");
			return REDIRECT_CART_LIST_ALL;
		}

		if (!cart.isPaymentCreated()) {
			result.addFlashAttribute("messageWarn", "O pagamento deve ser aprovado antes.");
			return REDIRECT_CART_LIST_ALL;
		}

		Pedido order = this.cart.finalizarPedido();
		orders.save(order);

		result.addFlashAttribute("messageInfo", "Pedido realizado. STATUS: " + order.getStatus());

		return REDIRECT_CART_LIST_ALL;
	}

	@RequestMapping("/listar")
	public String listar() throws Exception {

		// verificacao do estoque aqui

		return JSP_CART_LIST_ALL;
	}

}
