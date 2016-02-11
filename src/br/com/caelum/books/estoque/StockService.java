package br.com.caelum.books.estoque;

import java.util.List;

public interface StockService {

	StockItem getByCode(String code);

	List<StockItem> getAllStockItems(List<String> items);
	
}
