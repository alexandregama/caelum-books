package br.com.caelum.books.estoque;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.caelum.estoque.AuthorizationTokenException;
import br.com.caelum.estoque.ItemsByCode;
import br.com.caelum.estoque.ItemsByCodeResponse;
import br.com.caelum.estoque.StockEndpointWs;
import br.com.caelum.estoque.StockEndpointWsService;

@Component
//public class StockServiceSoap implements StockService {
public class StockServiceSoap {

//	@Override
	public StockItem getByCode(String code) {
		return null;
	}

//	@Override
	public List<StockItem> getAllStockItems(List<String> printedBooks) {
		StockEndpointWs endpointWs = new StockEndpointWsService().getStockEndpointWsPort();
		ItemsByCode itemsByCode = new ItemsByCode();
		
		itemsByCode.getCode().addAll(printedBooks);
		try {
			ItemsByCodeResponse itemsResponse = endpointWs.itemsByCode(itemsByCode, "AAA");
			List<br.com.caelum.estoque.StockItem> stockItems = itemsResponse.getStockItems();
			
			List<StockItem> items = new ArrayList<>();
			for (br.com.caelum.estoque.StockItem stockItem : stockItems) {
				items.add(new StockItem(stockItem.getCode(), stockItem.getQuantity(), 0));
			}
			return items;
		} catch (AuthorizationTokenException e) {
			throw new RuntimeException("An error ocurred while trying to get items via SOAP");
		}
	}

}
