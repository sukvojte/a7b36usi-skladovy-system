/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Controller;

import cz.a7b36usi.gui.IPrihlaseni;
import cz.a7b36usi.gui.Prihlaseni;
import cz.a7b36usi.sklad.Service.IUserService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Peter
 */
@Component
public class LoginController implements ILoginController {
//
    @Autowired
    private IUserService userService;
    
    @Autowired
    private IPrihlaseni p;

    @Autowired
    private IMainController mainController;
    
    public void showLogForm(String message) {
        System.out.println(message);
        p.showj(true);
        //TODO zobrazit ze se login vymrdal 
    }

    public void doLogin(String username, String password) {
        if (userService.logInUser(username, password)) {
            p.showj(false);
            mainController.showMainFrame("Login successfull");
        } else {
            showLogForm("Login unsuccessfull");
        }
    }
}
