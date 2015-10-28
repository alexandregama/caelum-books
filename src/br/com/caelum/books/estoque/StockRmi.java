package br.com.caelum.books.estoque;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StockRmi extends Remote {

	StockItem getByCode(String code) throws RemoteException;
	
	void decreaseQuantity(String code, Integer quantity) throws RemoteException;
	
}
