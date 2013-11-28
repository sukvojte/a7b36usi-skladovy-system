/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Controller.ifaces;
//

import javax.swing.table.TableModel;

/**
 *
 * @author Peter
 */
public interface IMainController {
    public void showMainFrame(String message);
    public TableModel getTableModel(int index);
}
