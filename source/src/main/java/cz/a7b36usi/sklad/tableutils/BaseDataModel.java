package cz.a7b36usi.sklad.tableutils;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import cz.a7b36usi.sklad.tableutils.filters.IFilter;

public abstract class BaseDataModel<T> extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2601925785859774182L;

	protected List<T> list;
	
	protected Column[] columns;
	
	protected List<IFilter> filters;
	
	public BaseDataModel(List<T> list) {
		this.list = list;
	}

	public abstract Object getColumnValue(T row, int index);
	
	
	@Override
    public String getColumnName(int column) {
        return columns[column].getName();
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

	public T getRowByIndex(int index) {
		return list.get(index);
	}
	
	public void update(List<T> list) {
		this.list = list;
		fireTableDataChanged();
	}
	
	public void setFilters(List<IFilter> filters) {
		this.filters = filters;
		applyFilters();
	}
	
	public void applyFilters(){
		
	}
	
    public Column getColumn(int column) {
        return columns[column];
    }
	
}
