/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Controller.ifaces;
//
import java.awt.event.ActionListener;

/**
 *
 * @author Peter
 */
public interface ILoginController {
    public void showLogForm(String message) ;
    public void doLogin(String username,char[] password);
}
