
package cz.a7b36usi.sklad.tableutils;

import cz.a7b36usi.sklad.DTO.UserDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lukas L.
 */
class UsersTableModel extends javax.swing.table.AbstractTableModel {
    ArrayList<ArrayList> rows;
    public static final  String columns [] = {"Username", "ACL"};

    public UsersTableModel(List<UserDTO> rowsFromDatabase) {
        rows = new ArrayList<ArrayList>();
        for (UserDTO userDTO : rowsFromDatabase) {
            ArrayList row = new ArrayList<Object>();
            row.add(userDTO.getUsername());
            row.add(userDTO.getAcl());
            rows.add(row);
        }
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
