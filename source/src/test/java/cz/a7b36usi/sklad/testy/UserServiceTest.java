package cz.a7b36usi.sklad.testy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cz.a7b36usi.sklad.BO.UserRole;
import cz.a7b36usi.sklad.DTO.UserDTO;
import cz.a7b36usi.sklad.Service.IPartnerService;
import cz.a7b36usi.sklad.Service.IUserService;

/**
 * Unit test for simple App.
 */
public class UserServiceTest extends AbstractServiceTest {

	@Autowired
	IUserService userService;

	@Autowired
	IPartnerService zakaznikService;

	@Test
	public void testAddUser() {
		String name = "lojza" + System.currentTimeMillis();
		String password = "nevim";
		UserRole ur = UserRole.VEDOUCI;
		Long id = userService.addUser(name, password.toCharArray(), ur);
		UserDTO u1 = userService.getUserById(id);
		UserDTO u2 = userService.getUserByUsername(name);
		userService.addUser("admin", "admin".toCharArray(), UserRole.VEDOUCI);
		assertNotNull(u1);
		assertNotNull(u2);
		assertFalse(userService.getAllUsers().isEmpty());
		assertEquals(name, u1.getUsername());
		assertEquals(name, u2.getUsername());
		assertTrue(userService.logInUser(u1.getUsername(), password.toCharArray()));
		assertTrue(userService.logInUser(u2.getUsername(), password.toCharArray()));
		assertEquals(ur, u1.getAcl());
		assertEquals(ur, u2.getAcl());
		assertEquals(id, u1.getId());
		assertEquals(id, u2.getId());
		
	}

	@Test
	public void testDeleteUser() {
		String name = "lojza" + System.currentTimeMillis();
		char password[] = "nevim".toCharArray();
		UserRole ur = UserRole.VEDOUCI;
		Long id = userService.addUser(name, password, ur);
		userService.deleteUser(id);
		assertNull(userService.getUserById(id));
		assertNull(userService.getUserByUsername(name));

	}

	@Test
	public void testUpdateUser() {
		String name = "lojza" + System.currentTimeMillis();
		String password = "nevim";
		UserRole ur = UserRole.VEDOUCI;
		Long id = userService.addUser(name, password.toCharArray(), ur);
		UserDTO u1 = userService.getUserById(id);
		String name2 = "hojza" + System.currentTimeMillis();
		u1.setUsername(name2);
		assertTrue(userService.updateUser(u1));
		UserDTO u2 = userService.getUserById(id);
		assertNotNull(u2);
		assertEquals(name2, u2.getUsername());
		assertEquals(id, u2.getId());
		assertEquals(password, u2.getPassword());
		assertEquals(ur, u2.getAcl());
	}

	@Test
	public void testGetAllUsers() {
		String name = "lojza" + System.currentTimeMillis();
		String password = "nevim";
		UserRole ur = UserRole.VEDOUCI;
		Long id = userService.addUser(name, password.toCharArray(), ur);
		String name2 = "lojza3" + System.currentTimeMillis();
		String password2 = "nevim";
		UserRole ur2 = UserRole.VEDOUCI;
		Long id2 = userService.addUser(name2, password2.toCharArray(), ur2);
		UserDTO u1 = userService.getUserById(id);
		UserDTO u2 = userService.getUserById(id2);
		List<UserDTO> list = userService.getAllUsers();
		assertFalse(list.isEmpty());
		boolean det1 = false;
		boolean det2 = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				UserDTO u = list.get(i);
				assertEquals(name, u.getUsername());
				assertEquals(id, u.getId());
				assertEquals(password, u.getPassword());
				assertEquals(ur, u.getAcl());
				det1 = true;
			} else if (list.get(i).getId().equals(id2)) {
				UserDTO u = list.get(i);
				assertEquals(name2, u.getUsername());
				assertEquals(id2, u.getId());
				assertEquals(password2, u.getPassword());
				assertEquals(ur, u.getAcl());
				det2 = true;
			}

		}
		assertTrue(det1);
		assertTrue(det2);
	}

	@Test
	public void testUpdatePassword() {
		String name = "lojza" + System.currentTimeMillis();
		String password = "nevim";
		UserRole ur = UserRole.VEDOUCI;
		Long id = userService.addUser(name, password.toCharArray(), ur);
		UserDTO u1 = userService.getUserById(id);
		String password2 = "hojza" + System.currentTimeMillis();
		userService.updatePassword(u1, password2.toCharArray());
		UserDTO u2 = userService.getUserById(id);
		assertNotNull(u2);
		assertEquals(name, u2.getUsername());
		assertEquals(id, u2.getId());
		assertEquals(password2, u2.getPassword());
		assertEquals(ur, u2.getAcl());
	}

	@Test
	public void testLogInUser() {
		String name = "lojza" + System.currentTimeMillis();
		String password = "nevim";
		UserRole ur = UserRole.VEDOUCI;
		Long id = userService.addUser(name, password.toCharArray(), ur);
		assertTrue(userService.logInUser(name, password.toCharArray()));
	}

}
