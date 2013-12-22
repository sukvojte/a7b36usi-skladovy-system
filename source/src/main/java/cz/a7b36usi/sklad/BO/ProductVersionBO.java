package cz.a7b36usi.sklad.BO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Lukas L.
 */
@Entity
@Table(name = "product_version")
public class ProductVersionBO extends AbstractBO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5814437849885161347L;

	@Column(nullable = false)
	private Long code;

	@Column(nullable = false)
	private String name;

	@ManyToOne
	private ProductBO product;

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductBO getProduct() {
		return product;
	}

	public void setProduct(ProductBO product) {
		this.product = product;
	}

}
