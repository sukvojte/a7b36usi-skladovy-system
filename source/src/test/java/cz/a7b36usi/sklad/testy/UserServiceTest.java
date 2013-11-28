package cz.a7b36usi.sklad.testy;

import cz.a7b36usi.sklad.BO.UserRole;
import cz.a7b36usi.sklad.Service.IUserService;
import cz.a7b36usi.sklad.Service.IZakaznikService;
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
    
    @Autowired
    IZakaznikService zakaznikService;
    
    @Test
    public void testAddUserAndRemove(){
        System.out.println("TESTUJU");
        if(userService.getUserById(new Long(1))==null){
            userService.addUser("admin", "admin".toCharArray(), UserRole.VEDOUCI);
        }
        userService.addUser("lojza"+System.currentTimeMillis(), "nevim".toCharArray(), UserRole.VEDOUCI);
    }
    
    @Test
    public void testAddZakaznik(){
        zakaznikService.addZakaznik(true, false, "ULICE", "mesto"+System.currentTimeMillis(), "BLA BLA"+System.currentTimeMillis(), 1, 2);
    }
}
