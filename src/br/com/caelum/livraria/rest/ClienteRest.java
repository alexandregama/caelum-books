package br.com.caelum.livraria.rest;

import java.io.Serializable;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

import org.springframework.aop.TargetClassAware;
import org.springframework.stereotype.Component;

import br.com.caelum.livraria.modelo.Pagamento;
import br.com.caelum.livraria.modelo.Transaction;

@Component
public class ClienteRest implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static final String SERVER_URI = "http://localhost:8080/caelum-books-payfast";
	private static final String ENTRY_POINT = "/payments/";

	public Pagamento createPayment(Transaction transaction) {
		Pagamento pagamento = ClientBuilder
			.newClient()
			.target(SERVER_URI + ENTRY_POINT)
			.request()
			.buildPost(Entity.xml(transaction))
			.invoke(Pagamento.class);
		return pagamento;
	}
	
	public Pagamento confirmarPagamento(Pagamento pagamento) {
		return null;
	}

}
