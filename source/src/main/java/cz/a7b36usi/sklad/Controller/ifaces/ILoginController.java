/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Controller.ifaces;

//

/**
 * 
 * @author Peter
 */
public interface ILoginController {
	/**
	 * Method which shows the logging form.
	 * 
	 * @param message
	 */
	public void showLogForm(String message);

	/**
	 * This method is used for user's login to system.
	 * 
	 * @param username
	 * @param password
	 */
	public void doLogin(String username, char[] password);
}
