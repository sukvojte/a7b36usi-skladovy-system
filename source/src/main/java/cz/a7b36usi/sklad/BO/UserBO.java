/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.BO;

import cz.a7b36usi.sklad.provider.IHashProvider;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 *
 * @author Peter
 */
/**
 * Definuje entitu User pro Hibernate
 */
@Entity
@Table(name = "users")
@Configurable(preConstruction = true)
public class UserBO extends AbstractBO {

    /**
     *
     */
    private static final long serialVersionUID = 2294763496607217663L;

    @Column(unique = true)
    private String username;

    private String password, salt;

    /**
     * Uzivatelska role
     */
    @Enumerated(EnumType.STRING)
    UserRole acl;

    @Autowired
    private transient IHashProvider hasher;

    /**
     * Defaultni konstruktor nastavi roli na nejakou hodnotu aby nebyla null
     */
    public UserBO() {
        this.acl = UserRole.SKLADNIK;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.salt = "salty" + System.currentTimeMillis();
        this.password = this.hasher.computeHash(password, salt);
    }

    public UserRole getAcl() {
        return acl;
    }

    public void setAcl(UserRole acl) {
        this.acl = acl;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(this.hasher.computeHash(password, this.salt));
    }

}
