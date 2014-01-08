package cz.a7b36usi.sklad.BO;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Lukas L.
 */
@Entity
@Table(name = "product")
public class ProductBO extends AbstractBO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3022086785139154940L;

	private String name;

	private String code;

	private Integer quantity;

	@ManyToOne
	private CategoryBO category;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public CategoryBO getCategory() {
		return category;
	}

	public void setCategory(CategoryBO category) {
		this.category = category;
	}
}
