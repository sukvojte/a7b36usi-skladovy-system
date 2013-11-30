package cz.a7b36usi.sklad.tableutils;

public class Column {

	private String name;
	private Class<?> type;
	
	
	public Column(String name, Class<?> type) {
		this.name = name;
		this.type = type;
	}
	
	public Column(String name) {
		this.name = name;
		this.type = String.class;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the type
	 */
	public Class<?> getType() {
		return type;
	}
		
}
