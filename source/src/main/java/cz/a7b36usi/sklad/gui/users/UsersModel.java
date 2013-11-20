/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.a7b36usi.sklad.gui.users;

import java.util.HashMap;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import cz.a7b36usi.sklad.DTO.UserDTO;
import cz.a7b36usi.sklad.tableutils.TableBindingList;
import cz.a7b36usi.sklad.tableutils.TableEvent;
import cz.a7b36usi.sklad.tableutils.TableEvent.Type;
import cz.a7b36usi.sklad.tableutils.TableListener;

/**
 *
 * @author Vojta
 */
class UsersModel implements TableModel {

	class UserModelListener implements TableListener{

		private TableModelListener listener;
		private TableModel source;
		
		public UserModelListener(TableModelListener listener, TableModel source){
			this.listener = listener;
			this.source = source;
		}
		
		public void tableChanged(TableEvent e) {
			
			TableModelEvent event = null; 
			if(e.getType() == Type.ALL){
				event = new TableModelEvent(source);
			}else{
				event = new TableModelEvent(source, e.getRowId());
			}
			
			listener.tableChanged(event);
		}
		
	}
	
	private TableBindingList<UserDTO> users;
	private HashMap<TableModelListener, UserModelListener> listeners;
	
    public UsersModel(TableBindingList<UserDTO> users) {
    	this.users = users;
    	listeners = new HashMap<TableModelListener, UsersModel.UserModelListener>();
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
    	UserModelListener ul = new UserModelListener(l, this);
    	listeners.put(l, ul);
    	this.users.addTableListener(ul);
    }

    public void removeTableModelListener(TableModelListener l) {
    	
    	UserModelListener ul = listeners.get(l);
    	this.users.removeTableListener(ul);
    }

    public UserDTO getUser(int position) {
        return this.users.get(position);
    }
    
}
