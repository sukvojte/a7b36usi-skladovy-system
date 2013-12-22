package cz.a7b36usi.sklad.DTO;


/**
 * 
 * @author Lukas L.
 */
public class CategoryDTO extends AbstractDTO {

	private String name;

	private Long parrent;

	public CategoryDTO(Long id, String name, Long parrent) {
		this.name = name;
		this.parrent = parrent;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParrent() {
		return parrent;
	}

	public void setParrent(Long parrent) {
		this.parrent = parrent;
	}

}
