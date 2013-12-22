package cz.a7b36usi.sklad.BO;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Lukas L.
 */
@Entity
@Table(name = "category")
public class CategoryBO extends AbstractBO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7849263354633563899L;

	private String name;

	@ManyToOne
	private CategoryBO parrent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryBO getParrent() {
		return parrent;
	}

	public void setParrent(CategoryBO parrent) {
		this.parrent = parrent;
	}

}
