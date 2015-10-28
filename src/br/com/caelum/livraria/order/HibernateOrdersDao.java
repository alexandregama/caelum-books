package br.com.caelum.livraria.order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.caelum.livraria.modelo.Pedido;

@Component
@Scope("request")
class HibernateOrdersDao implements Orders {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void save(Pedido order) {
		manager.persist(order);
	}

}
