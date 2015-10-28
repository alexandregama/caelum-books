package br.com.caelum.books.estoque;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.springframework.stereotype.Component;

@Component
public class StockService {
	
	private String STOCK_API_URL = "rmi://localhost:1099/stock";

	public StockItem getByCode(String code) {
		try {
			StockRmi service = (StockRmi) Naming.lookup(STOCK_API_URL);
			
			return service.getByCode(code);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RuntimeException("Error while trying to get StockItem by code using RMI", e);
		}
	}
	
	public void decreaseQuantity(String code, Integer quantity) {
		try {
			StockRmi service = (StockRmi) Naming.lookup(STOCK_API_URL);
			
			service.decreaseQuantity(code, quantity);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RuntimeException("Error while trying to decrease stock quantity using RMI", e);
		}
	}
	
}
