/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.BO.UserBO;
import cz.a7b36usi.sklad.BO.UserRole;
import cz.a7b36usi.sklad.DTO.UserDTO;

/**
 * 
 * @author Peter
 */
@Component
public class UserService extends AbstractService implements IUserService {

	public Long addUser(String username, char[] password, UserRole acl) {
		UserBO user = new UserBO();
		user.setAcl(acl);
		user.setPassword(new String(password));
		Arrays.fill(password, (char) 0);
		user.setUsername(username);
		return genericDAO.saveOrUpdate(user).getId();
	}

	public void deleteUser(Long userId) {
		if (userId != null) {
			genericDAO.removeById(userId, UserBO.class);
		}
	}

	public UserDTO getUserById(Long id) {
		UserBO user = genericDAO.getById(id, UserBO.class);
		if (user == null) {
			return null;
		}
		return new UserDTO(user.getId(), user.getUsername(), user.getAcl(),
				user.getPassword());
	}

	public List<UserDTO> getAllUsers() {
		List<UserBO> bolist = genericDAO.getAll(UserBO.class);
		List<UserDTO> users = new ArrayList<UserDTO>();
		for (UserBO user : bolist) {
			users.add(new UserDTO(user.getId(), user.getUsername(), user
					.getAcl(), user.getPassword()));
		}
		return users;
	}

	public boolean logInUser(String username, char[] password) {
		try {
			UserBO user = genericDAO.getByPropertyUnique("username", username,
					UserBO.class);
			if (user == null) {
				return false;
			}

			return user.checkPassword(new String(password));
		} catch (NoResultException e) {
			return false;
		}

	}

	public boolean updateUser(UserDTO user) {
		UserBO u = new UserBO();

		u.setUsername(user.getUsername());
		u.setAcl(user.getAcl());
		u.setId(user.getId());
		u.setPassword(user.getPassword());

		genericDAO.saveOrUpdate(u);

		return true;
	}

	public void updatePassword(UserDTO user, char[] password) {
		UserBO u = genericDAO.loadById(user.getId(), UserBO.class);
		u.setPassword(new String(password));
		genericDAO.saveOrUpdate(u);

		Arrays.fill(password, (char) 0);//TODO: Proc to tu je ?
	}

	public UserDTO getUserByUsername(String username) {
		UserBO user = null;
		try {
			user = genericDAO.getByPropertyUnique("username", username,
					UserBO.class);
		} catch (NoResultException e) {
			return null;
		}
		return new UserDTO(user.getId(), user.getUsername(), user.getAcl(),
				user.getPassword());
	}
}
