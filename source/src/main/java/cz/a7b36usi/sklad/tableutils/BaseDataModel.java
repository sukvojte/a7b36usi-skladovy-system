package cz.a7b36usi.sklad.tableutils;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public abstract class BaseDataModel<T> extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2601925785859774182L;

	protected List<T> list;
	
	protected String[] columns;
	
	public BaseDataModel(List<T> list) {
		this.list = list;
	}

	@Override
    public String getColumnName(int column) {
        return columns[column];
    }
	
	public int getRowCount() {
		return list.size();
	}

	public int getColumnCount() {
		return columns.length;
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		return getColumnValue(list.get(rowIndex), columnIndex);
	}

	public abstract Object getColumnValue(T row, int index);
	
}
