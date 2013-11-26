//
//package cz.a7b36usi.sklad.tableutils;
//
//import java.util.List;
//
///**
// *
// * @author Lukas L.
// */
//abstract class AbstractTableModel<E>  extends javax.swing.table.AbstractTableModel{
//    
//    List<E> rows;
//
//    public AbstractTableModel(List<E> rows) {
//        this.rows = rows;
//    }
//    
//    @Override
//    public Class<E> getColumnClass(int columnIndex) {
//        return E;
//    }
//
//    @Override
//    public String getColumnName(int column) {
//        return super.getColumnName(column);
//    }
//
//    public int getRowCount() {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    public int getColumnCount() {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//    
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    @Override
//    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//        super.setValueAt(aValue, rowIndex, columnIndex);
//    }
//    
//    
//}
