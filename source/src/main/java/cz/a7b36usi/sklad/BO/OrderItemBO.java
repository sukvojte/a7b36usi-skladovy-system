/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.BO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Peter
 */

/**
 * Entita ktera slouzi pro uchovani informace o poctu pruduktu v jedne
 * objednavce
 */
@Entity
@Table(name = "orderitem")
public class OrderItemBO extends AbstractBO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9136191201404945820L;

	@ManyToOne
	@JoinColumn(nullable = false)
	private ProductBO product;

	@Column(nullable = false)
	private int quantity;

	@JoinColumn(name = "wrapping")
	@ManyToOne
	private WrappingTypeBO wrappingType;

	@JoinColumn(name = "version")
	@ManyToOne
	private ProductVersionBO productVersion;

	@JoinColumn(nullable = false)
	@ManyToOne
	private OrderBO order;

	public OrderItemBO() {
	}

	// ***************** GETTER SETTER KILOMETER BY PETER
	// ********************************
	public ProductBO getProduct() {
		return product;
	}

	public void setProduct(ProductBO product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public WrappingTypeBO getWrappingType() {
		return wrappingType;
	}

	public void setWrappingType(WrappingTypeBO wrappingType) {
		this.wrappingType = wrappingType;
	}

	public ProductVersionBO getProductVersion() {
		return productVersion;
	}

	public void setProductVersion(ProductVersionBO productVersion) {
		this.productVersion = productVersion;
	}

	public OrderBO getOrder() {
		return order;
	}

	public void setOrder(OrderBO order) {
		// order.getItems().add(this);
		this.order = order;
	}

}
