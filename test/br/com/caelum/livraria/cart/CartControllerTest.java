package br.com.caelum.livraria.cart;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.caelum.livraria.book.Books;
import br.com.caelum.livraria.modelo.BookFormat;
import br.com.caelum.livraria.modelo.Livro;

@RunWith(MockitoJUnitRunner.class)
public class CartControllerTest {

	@Mock
	private Books books;
	
	@Mock
	private Cart cart;
	
	@InjectMocks
	private CartController controller;
	
	@Test
	public void shouldFindBookWhenUserAddABookToCart() throws Exception {
		controller.addItemToCart(10, BookFormat.IMPRESSO);
		
		verify(books).findById(10);
	}
	
	@Test
	public void shouldAddANewBookToCart() throws Exception {
		Livro bookAdded = new Livro();
		
		when(books.findById(10)).thenReturn(bookAdded);
		
		controller.addItemToCart(10, BookFormat.IMPRESSO);
		
		verify(cart).add(bookAdded, BookFormat.IMPRESSO);
	}
	
	@Test
	public void shouldRedirectUserToCartListWhenUserAddNewBookToCart() throws Exception {
		String redirectUrl = controller.addItemToCart(10, BookFormat.IMPRESSO);
		
		assertEquals("redirect:/carrinho/listar", redirectUrl);
	}
	
}
