package br.com.caelum.livraria.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Pagamento implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String STATUS_CRIADO = "CRIADO";
	private static final String STATUS_CONFIRMADO = "CONFIRMADO";
	private static final String STATUS_CANCELADO = "CANCELADO";
	
	@Id
	private Integer id;
	private String status;
	private BigDecimal value;
	private ArrayList<Link> links = new ArrayList<>();

	public void setStatus(final String status) {
		this.status = status;
	}

	public void setValue(final BigDecimal value) {
		this.value = value;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public BigDecimal getValue() {
		return this.value;
	}

	public Integer getId() {
		return this.id;
	}

	public ArrayList<Link> getLinks() {
		return this.links;
	}
	
	public Link getLinkPeloRel(String rel) {
		for (Link link : this.links) {
			if(link.getRel().equals(rel)) {
				return link;
			}
		}
		return null;
	}

	public boolean ehCriado() {
		return STATUS_CRIADO.equals(this.status);
	}
	
	public boolean ehConfirmado() {
		return STATUS_CONFIRMADO.equals(this.status);
	}
	
	public boolean ehCancelado() {
		return STATUS_CANCELADO.equals(this.status);
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + this.id + ", status=" + this.status + ", valor=" + this.value + ", links="
				+ this.links + "]";
	}

}
