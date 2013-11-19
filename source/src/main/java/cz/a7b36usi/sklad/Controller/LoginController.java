/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Service.IUserService;
import cz.a7b36usi.sklad.gui.IPrihlaseni;

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
        p.setVisible(true);
    }

    public void doLogin(String username, String password) {
        if (userService.logInUser(username, password)) {
            p.setVisible(false);
            mainController.showMainFrame("Login successfull");
        } else {
            showLogForm("Login unsuccessfull");
        }
    }
}
