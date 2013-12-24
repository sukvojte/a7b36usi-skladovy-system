/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.BO;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Peter
 */
@Entity
@Table(name = "orders")
public class OrderBO extends AbstractBO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 636941719957632910L;

	@Temporal(TemporalType.DATE)
	@Column(name = "orderDate", nullable = false)
	private Date date;

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "order")
	private List<OrderItemBO> items;

	@ManyToOne
	@JoinColumn(nullable = false)
	private PartnerBO partner;

	private String number;

	public OrderBO() {
	}

	// ***************** GETTER SETTER KILOMETER BY PETER
	// ********************************
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<OrderItemBO> getItems() {
		return items;
	}

	public void setItems(List<OrderItemBO> items) {
		this.items = items;
	}

	public PartnerBO getPartner() {
		return partner;
	}

	public void setPartner(PartnerBO partner) {
		this.partner = partner;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
