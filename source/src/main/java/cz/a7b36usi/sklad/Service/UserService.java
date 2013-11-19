/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Service;

import cz.a7b36usi.sklad.BO.UserBO;
import cz.a7b36usi.sklad.BO.UserRole;
import cz.a7b36usi.sklad.DTO.UserDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Peter
 */
public class UserService extends AbstractService implements IUserService {

    /**
     * Prida uzivatele do databaze
     * @param username Uzivatelske jmeno
     * @param password Heslo
     * @param acl Uzivatelska role
     * @return Id pridaneho uzivatele
     */
    @Override
    public Long addUser(String username, String password, UserRole acl) {
        UserBO user = new UserBO();

        return genericDAO.saveOrUpdate(user).getId();
    }

    /**
     * Smaze uzivatele s danym identifikatorem z databaze
     * @param userId Identifikator uzivatele ktery ma byt smazan
     */
    @Override
    public void deleteUser(Long userId) {
        genericDAO.removeById(userId, UserBO.class);
    }

    /**
     * Vyhleda v databazi uzivatele s danym identifikatorem a vrati jeho DTO
     * @param id Identifikator hledanehop uzivatele
     * @return DTO s informacemi o hledanem uzivateli nebo null pokud nebyl nalezen
     */
    @Override
    public UserDTO getUserById(Long id) {
        UserBO user = genericDAO.getById(id, UserBO.class);
        return new UserDTO(user.getId(),user.getUsername(), user.getAcl());
    }

    /**
     * Vyhleda v databazi uzivatele s danym identifikatorem a vrati jeho DTO
     * @return List obsahujici DTO s informacemi o vsech nalezenych uzivatelich nebo null pokud nebyl nalezen zadny zaznam
     */
    @Override
    public List<UserDTO> getAllUsers() {
        List<UserBO> bolist = genericDAO.getAll(UserBO.class);
        List<UserDTO> users = new ArrayList<UserDTO>();
        for (UserBO user : bolist) {
            users.add( new UserDTO(user.getId(),user.getUsername(), user.getAcl()));
        }
        return users;
    }

    /**
     * Overi zda uzivatel s danym jmenem a heslem existuje a zda je heslo spravne zadano
     * @param username Uzivatelske jmeno
     * @param password Heslo
     * @return true pokud je jmeno i heslo spravne, jinak false
     */
    @Override
    public boolean logInUser(String username, String password) {
        UserBO user = genericDAO.getByPropertyUnique("username", username, UserBO.class);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }
}
