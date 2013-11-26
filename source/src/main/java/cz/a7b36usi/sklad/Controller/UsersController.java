/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.BO.UserRole;
import cz.a7b36usi.sklad.Controller.ifaces.IUsersController;
import cz.a7b36usi.sklad.DTO.UserDTO;
import cz.a7b36usi.sklad.Service.IUserService;
import cz.a7b36usi.sklad.gui.users.ifaces.IUsersGUI;
import cz.a7b36usi.sklad.tableutils.TableBindingList;
import cz.a7b36usi.sklad.tableutils.TableEvent;
//

/**
 *
 * @author Peter
 */
@Component
public class UsersController implements IUsersController {

    @Autowired
    private IUsersGUI usersGui;
    @Autowired
    private IUserService userService;
    private TableBindingList<UserDTO> model;

    public void showUsersForm() {
        model = new TableBindingList<UserDTO>(userService.getAllUsers()); // TODO: hibernate nejak nechodi 
        //updateModel(); // TODO END

        usersGui.setUsers(model);
        usersGui.setVisible(true);
    }

    public void deleteUser(UserDTO user) {
        model.remove(user); // TODO: hibernate nejak nechodi
        userService.deleteUser(user.getId());
        updateModel();
    }

    public void updateUser(UserDTO user) {
        for (UserDTO u : model) { // TODO: hibernate nejak nechodi
            if (u.getId() == user.getId()) {
                u.setUsername(user.getUsername());
                u.setAcl(user.getAcl());
            }
        }
        userService.updateUser(user);  // TODO END
        updateModel();
    }

    public void updatePassword(UserDTO user, char[] password) {
        userService.updatePassword(user, password);
    }

    public void createUser(String username, char[] password, UserRole acl) {
        model.add(new UserDTO((long) 0, username, acl)); // TODO: hibernate nejak nechodi
        userService.addUser(username, password, acl);
        updateModel();
    }

    public void updateModel() {
        // model = new TableBindingList<UserDTO>(userService.getAllUsers()); // TODO: hibernate nejak nechodi 
        model.fireListeners(new TableEvent(TableEvent.Type.ALL));
    }
}
