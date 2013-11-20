/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Controller.ifaces.IUsersController;
import cz.a7b36usi.sklad.DTO.UserDTO;
import cz.a7b36usi.sklad.Service.IUserService;
import cz.a7b36usi.sklad.Service.UserService;
import cz.a7b36usi.sklad.gui.users.ifaces.IUsersGUI;
//
/**
 *
 * @author Peter
 */
@Component
public class UsersController implements IUsersController{

	@Autowired
    private IUsersGUI usersGui;
	
	@Autowired
	private IUserService users;
    
    public void showUsersForm() {
    	usersGui.setUsers(users.getAllUsers());
    	usersGui.setVisible(true);
    }
    
}
