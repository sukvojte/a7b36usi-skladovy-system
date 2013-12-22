/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.BO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 *
 * @author Peter
 */

/**
 * Definuje entitu User pro Hibernate
 */
@Entity
@Table(name = "users")
public class UserBO extends AbstractBO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2294763496607217663L;

	@Column(unique = true)
	private String username;

	private String password;

	/**
	 * Uzivatelska role
	 */
	@Enumerated(EnumType.STRING)
	UserRole acl;

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
		this.password = password;
	}

	public UserRole getAcl() {
		return acl;
	}

	public void setAcl(UserRole acl) {
		this.acl = acl;
	}

}
