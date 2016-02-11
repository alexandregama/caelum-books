package br.com.caelum.livraria.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;

	private String number;
	private String titular;
	private BigDecimal value;

	public void setNumber(final String numero) {
		this.number = numero;
	}

	public void setValor(final BigDecimal valor) {
		this.value = valor;
	}

	public void setTitular(final String titular) {
		this.titular = titular;
	}
	
	public String getNumber() {
		return this.number;
	}

	public String getTitular() {
		return this.titular;
	}


	public BigDecimal getValor() {
		return this.value;
	}

	@Override
	public String toString() {
		return "Transacao [numero=" + this.number + ", titular=" + this.titular +  ", valor="
				+ this.value + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (titular == null) {
			if (other.titular != null)
				return false;
		} else if (!titular.equals(other.titular))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	

}
