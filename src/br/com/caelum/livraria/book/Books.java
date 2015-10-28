package br.com.caelum.livraria.book;

import br.com.caelum.livraria.modelo.Livro;

public interface Books {

	Livro findById(Integer id);
	
}
