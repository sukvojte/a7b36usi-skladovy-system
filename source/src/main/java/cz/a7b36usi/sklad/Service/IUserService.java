/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Service;

import cz.a7b36usi.sklad.BO.UserRole;
import cz.a7b36usi.sklad.DTO.UserDTO;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Peter
 */
public interface IUserService {
    
    public boolean logInUser(String username,char[] password);
    
    public Long addUser(String username,String password, UserRole acl);


    public void deleteUser(Long userId);

    @Transactional(readOnly=true)
    public UserDTO getUserById(Long id);

 
    @Transactional(readOnly=true)
    public List<UserDTO> getAllUsers();
    
}
