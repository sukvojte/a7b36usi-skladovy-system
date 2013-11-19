/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Controller;

import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.gui.SkladMainGUI;
//
/**
 *
 * @author Peter
 */
@Component
public class MainController implements IMainController{

    private SkladMainGUI mainGui;
    
    public void showMainFrame(String message) {
        mainGui.setVisible(true);
    }
    
}
