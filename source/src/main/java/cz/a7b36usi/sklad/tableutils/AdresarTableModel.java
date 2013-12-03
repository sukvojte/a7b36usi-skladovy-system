
package cz.a7b36usi.sklad.tableutils;

import cz.a7b36usi.sklad.DTO.ZakaznikDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lukas L.
 */
public class AdresarTableModel extends javax.swing.table.AbstractTableModel {
    ArrayList<ArrayList> rows;
    public static final  String columns [] = {"Spolecnost", "Mesto", "Ulice"};

    public AdresarTableModel(List<ZakaznikDTO> rowsFromDatabase) {
        rows = new ArrayList<ArrayList>();
        for (ZakaznikDTO zakaznikDTO : rowsFromDatabase) {
            ArrayList row = new ArrayList<Object>();
            row.add(zakaznikDTO.getSpolecnost());
            row.add(zakaznikDTO.getMesto());
            row.add(zakaznikDTO.getUlice());
            rows.add(row);
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    public int getRowCount() {
        return rows.size();
    }

    public int getColumnCount() {
        return columns.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex).get(columnIndex);
    }

}
