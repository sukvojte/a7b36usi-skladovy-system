/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.DTO;

import cz.a7b36usi.sklad.BO.UserRole;

/**
 *
 * @author Peter
 */


/**
 * DTO objekty slouzi k prenaseni dat mezi servisni vrstvou a vyssimi vrstvami aplikace
 */
public class UserDTO extends AbstractDTO{
    
    private String username;
    private UserRole acl;
    private String password;

    /**
     * Pro jistotu se neprenasi v DTO password
     * @param acl Uzivatelska role
     * @param username Uzivatelske jmeno
     */
    public UserDTO(Long id,String username, UserRole acl, String pass) {
        this.username = username;
        this.acl = acl;
        this.id=id;
        this.password = pass;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public UserRole getAcl() {
        return acl;
    }

    public void setAcl(UserRole acl) {
        this.acl = acl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
