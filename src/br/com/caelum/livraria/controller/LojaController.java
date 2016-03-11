package br.com.caelum.livraria.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.livraria.modelo.Livro;

@RestController
@RequestMapping("/loja")
public class LojaController {

	@PersistenceContext
	EntityManager entityManager;
	
	@RequestMapping("/livro")
	public String form(@RequestParam(value="id", required=true) Integer id, Model modelo) {
		Livro livro = entityManager.find(Livro.class, id);
		modelo.addAttribute("livro", livro);
		return "loja/formulario" ;
	}
	
	@RequestMapping("/index")
	public String index(Model modelo) {
		List<Livro> livros = this.entityManager.createQuery("select livro from Livro livro", Livro.class).getResultList();
		modelo.addAttribute("livros", livros);
		return "loja/index";
	}

	@ResponseBody
	@RequestMapping(value = "/livros/menos-vendidos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Livro> livrosMenosVendidos() {
		List<Livro> livros = this.entityManager.createQuery("select livro from Livro livro", Livro.class).getResultList();
		
		return livros;
	}
	
	@RequestMapping(value = "/livros/best-sellers", method = RequestMethod.GET)
	public ResponseEntity<List<Livro>> booksBestSellers() {
		List<Livro> books = this.entityManager.createQuery("select livro from Livro livro", Livro.class).getResultList();
		
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
	
}
