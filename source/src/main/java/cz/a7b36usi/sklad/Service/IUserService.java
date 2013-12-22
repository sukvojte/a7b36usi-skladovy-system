/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cz.a7b36usi.sklad.BO.UserRole;
import cz.a7b36usi.sklad.DTO.UserDTO;

/**
 * 
 * @author Peter
 */
public interface IUserService {
	/**
	 * Log in with username and password
	 * 
	 * @param username
	 * @param password
	 * @return true if username and password match with values from database,
	 *         false otherwise
	 */
	public boolean logInUser(String username, char[] password);

	/**
	 * Adds user to database
	 * 
	 * @param username
	 * @param password
	 * @param acl
	 * @return id of database entity
	 */
	public Long addUser(String username, char[] password, UserRole acl);

	/**
	 * Delete user entity from database by id
	 * 
	 * @param userId
	 */
	public void deleteUser(Long userId);

	/**
	 * Gets user by id
	 * 
	 * @param id
	 * @return UserDTO
	 */
	@Transactional(readOnly = true)
	public UserDTO getUserById(Long id);

	/**
	 * Gets user by username
	 * 
	 * @param username
	 * @return UserDTO
	 */
	@Transactional(readOnly = true)
	public UserDTO getUserByUsername(String username);

	/**
	 * Gets all users from database
	 * 
	 * @return list of UserDTOs
	 */
	@Transactional(readOnly = true)
	public List<UserDTO> getAllUsers();

	/**
	 * Persists user
	 * 
	 * @param user
	 * @return true
	 */
	boolean updateUser(UserDTO user);

	/**
	 * Updates password
	 * 
	 * @param user
	 * @param password
	 */
	void updatePassword(UserDTO user, char[] password);
}
