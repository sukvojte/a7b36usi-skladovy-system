package cz.a7b36usi.sklad.testy;

import cz.a7b36usi.sklad.BO.UserRole;
import cz.a7b36usi.sklad.Service.IUserService;
import cz.a7b36usi.sklad.Service.UserService;
//import junit.framework.Test;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Unit test for simple App.
 */
public class UserServiceTest extends AbstractServiceTest
{

    @Autowired
    IUserService userService;
    
    @Test
    public void testAddUserAndRemove(){
        userService.addUser("lojza"+System.currentTimeMillis(), "nevim".toCharArray(), UserRole.VEDOUCI);
    }
}
