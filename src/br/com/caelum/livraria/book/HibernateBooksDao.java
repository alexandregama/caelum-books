package br.com.caelum.livraria.book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.caelum.livraria.modelo.Livro;

@Component
@Scope("request")
public class HibernateBooksDao implements Books {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Livro findById(Integer id) {
		return manager.find(Livro.class, id);
	}

}
