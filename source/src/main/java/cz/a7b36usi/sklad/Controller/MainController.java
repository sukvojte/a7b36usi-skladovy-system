/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.App;
import cz.a7b36usi.sklad.Tabs;
import cz.a7b36usi.sklad.Controller.ifaces.IMainController;
import cz.a7b36usi.sklad.Service.IUserService;
import cz.a7b36usi.sklad.gui.main.ifaces.ISkladMainGUI;
import cz.a7b36usi.sklad.gui.main.ifaces.ISkladMainGUI;
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

	static final Logger logger = Logger.getLogger(MainController.class);
	
    @Autowired
    private ISkladMainGUI mainGui;

    
    @Autowired
    private IUserService userService;
    
    public void showMainFrame(String message) {
        //System.out.println(message);
        mainGui.setVisible(true);
        
        mainGui.addListeners(new IMainGuiListener() {
			
			public void tabChanged(Tabs activetTab) {
				// TODO: action
				logger.debug("Tab changed to " + activetTab);
			}
			
			public void productSave() {
				// TODO: action				
				logger.debug("Product save");
			}
		});
       
        
    }
}
