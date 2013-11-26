/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Controller.ifaces.IMainController;
import cz.a7b36usi.sklad.gui.main.ifaces.ISkladMainGUI;
//
/**
 *
 * @author Peter
 */
@Component
public class MainController implements IMainController{

    @Autowired
    private ISkladMainGUI mainGui;
    
    public void showMainFrame(String message) {
        //System.out.println(message);
        mainGui.setVisible(true);
    }
    
}
