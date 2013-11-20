/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Controller.ifaces.ILoginController;
import cz.a7b36usi.sklad.Controller.ifaces.IMainController;
import cz.a7b36usi.sklad.Service.IUserService;
import cz.a7b36usi.sklad.gui.login.ifaces.IPrihlaseni;

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
    private IPrihlaseni loginForm;

    @Autowired
    private IMainController mainController;
    
    public void showLogForm(String message) {
        loginForm.setVisible(true);
    }

    public void doLogin(String username, char[] password) {
        if (userService.logInUser(username, password)) {
            loginForm.setVisible(false);
            mainController.showMainFrame("Login successfull");
        } else {
        	loginForm.showError("Login unsuccessfull");
        }
    }
}
