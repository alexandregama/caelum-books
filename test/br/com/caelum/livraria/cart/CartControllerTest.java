package br.com.caelum.livraria.cart;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.caelum.livraria.book.Books;
import br.com.caelum.livraria.modelo.BookFormat;

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
	
}
