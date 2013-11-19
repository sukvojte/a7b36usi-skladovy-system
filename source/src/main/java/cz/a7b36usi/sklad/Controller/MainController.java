/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Controller;

import cz.a7b36usi.gui.SkladMainGUI;
import org.springframework.stereotype.Component;
//
/**
 *
 * @author Peter
 */
@Component
public class MainController implements IMainController{

    private SkladMainGUI mainGui;
    
    public void showMainFrame(String message) {
        System.out.println(message);
        //mainGui.setVisible(true);
    }
    
}
