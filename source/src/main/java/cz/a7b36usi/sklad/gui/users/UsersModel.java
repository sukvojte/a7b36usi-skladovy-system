/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.a7b36usi.sklad.gui.users;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import cz.a7b36usi.sklad.DTO.UserDTO;

/**
 *
 * @author Vojta
 */
class UsersModel implements TableModel {

	private List<UserDTO> users;
	private List<TableModelListener> listeners;
	
	
    public UsersModel(List<UserDTO> users) {
    	this.users = users;
    	this.listeners = new ArrayList<TableModelListener>();
    }

    public int getRowCount() {
        return users.size();
    }

    public int getColumnCount() {
        return UserDTO2GUI.getFieldCount();
    }

    public String getColumnName(int columnIndex) {
        return UserDTO2GUI.getFields()[columnIndex];
    }

    public Class<?> getColumnClass(int columnIndex) {
        return UserDTO2GUI.getFieldTypes()[columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return UserDTO2GUI.getRowValue(users.get(rowIndex), columnIndex);
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
    }

    public void addTableModelListener(TableModelListener l) {
    	this.listeners.add(l);
    }

    public void removeTableModelListener(TableModelListener l) {
    	this.listeners.remove(l);
    }
    
}
