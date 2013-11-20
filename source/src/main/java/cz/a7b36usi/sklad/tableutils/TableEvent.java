package cz.a7b36usi.sklad.tableutils;

public class TableEvent {
	
	public enum Type{
		ALL,
		REMOVE,
		UPDATE,
		INSERT
	}
	
	private int rowId;
	private Type type;

	public TableEvent(Type t){
		rowId = 0;
		type = t;
	}
	
	public TableEvent(Type t, int r){
		rowId = r;
		type = t;
	}

	public int getRowId() {
		return rowId;
	}

	public Type getType() {
		return type;
	}
	
}
