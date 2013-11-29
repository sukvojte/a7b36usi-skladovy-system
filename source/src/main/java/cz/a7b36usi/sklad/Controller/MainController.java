/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Tabs;
import cz.a7b36usi.sklad.Controller.ifaces.IMainController;
import cz.a7b36usi.sklad.Service.IUserService;
import cz.a7b36usi.sklad.gui.main.ifaces.ISkladMainGUI;
import cz.a7b36usi.sklad.gui.main.ifaces.InterfaceSkladMainGUI;
import cz.a7b36usi.sklad.gui.main.listeners.IMainGuiListener;
import cz.a7b36usi.sklad.tableutils.UsersTableModel;

import javax.swing.table.TableModel;
//
/**
 *
 * @author Peter
 */
@Component
public class MainController implements IMainController{

    @Autowired
    private ISkladMainGUI mainGui;
    
    private InterfaceSkladMainGUI test;
    
    @Autowired
    private IUserService userService;
    
    public void showMainFrame(String message) {
        //System.out.println(message);
        mainGui.setVisible(true);
        
        test.addListeners(new IMainGuiListener() {
			
			public void tabChanged(Tabs activetTab) {
				System.out.println("aa");
				
			}
			
			public void productSave() {
				// TODO Auto-generated method stub
				
			}
		});
       
        
    }
}
