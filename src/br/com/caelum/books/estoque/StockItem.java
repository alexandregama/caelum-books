package br.com.caelum.books.estoque;

import java.io.Serializable;

public class StockItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;
	
	private Integer quantity;
	
	private transient Integer internalCode; //won't be serialized

	public StockItem(String code, Integer quantity, Integer interInteger) {
		this.code = code;
		this.quantity = quantity;
		internalCode = interInteger;
	}

	public String getCode() {
		return code;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Integer getInternalCode() {
		return internalCode;
	}
	
	@Override
	public String toString() {
		return "code: " + this.code + ", quantity: " + this.quantity;
	}
}
