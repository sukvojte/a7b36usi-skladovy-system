/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Controller;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Tabs;
import cz.a7b36usi.sklad.Controller.ifaces.IMainController;
import cz.a7b36usi.sklad.Controller.states.IControllerState;
import cz.a7b36usi.sklad.Controller.states.IStateFactory;
import cz.a7b36usi.sklad.gui.main.ifaces.ISkladMainGUI;
import cz.a7b36usi.sklad.gui.main.listeners.IMainGuiListener;
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
    private IStateFactory stateFactory;
    
    private IControllerState state;
    
    
    @PostConstruct
    public void registerListeners() {
    	final MainController ctrl = this;
    	mainGui.addListeners(new IMainGuiListener() {
			
    		public void tabChanged(Tabs activeTab) {
				logger.debug("Tab changed to " + activeTab);
				
				state = stateFactory.getStateByTab(activeTab);
				state.activated(ctrl);
			}
			
			public void editFormSave() {
				logger.debug("Product save");
				state.editFormSave(ctrl);
			}

			public void tableSelectedIndex(int index) {
				logger.debug("Selected index " + index);
				state.selectedItem(ctrl, index);
			}

            public void deleteItem() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
		});
    	
    	state = stateFactory.getDefaultState();
    	mainGui.switchTab(Tabs.ADDRESS_BOOK);
    	
    }
    
    public void showMainFrame(String message) {
        mainGui.setVisible(true);
    }
    
    public ISkladMainGUI getForm(){
    	return mainGui; 
    }
    
}
