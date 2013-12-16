package cz.a7b36usi.sklad.Controller.ifaces;

import cz.a7b36usi.sklad.BO.UserRole;
import cz.a7b36usi.sklad.DTO.UserDTO;

public interface IUsersController {

    /**
     * Method for 
     *
     * @param message
     */
    void showUsersForm();

    /**
     * 
     * @param user 
     */ 
    void deleteUser(UserDTO user);

    void updateUser(UserDTO user);

    void updatePassword(UserDTO user, char[] password);

    void createUser(String username, char[] password, UserRole acl);
}
