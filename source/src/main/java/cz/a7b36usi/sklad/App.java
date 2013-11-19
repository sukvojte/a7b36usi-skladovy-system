package cz.a7b36usi.sklad;

import cz.a7b36usi.sklad.BO.Test;
import cz.a7b36usi.sklad.BO.Tester;
<<<<<<< HEAD
import cz.a7b36usi.sklad.Controller.LoginController;
import cz.a7b36usi.sklad.gui.Prihlaseni;

=======
import cz.a7b36usi.sklad.Controller.ILoginController;
import cz.a7b36usi.sklad.Controller.LoginController;
>>>>>>> 819b6fbc00aeafacf90cd397be0d059bd461db1e
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 *
 */


public class App 
{
    
    
    
    
    
    public static void main( String[] args )
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        
<<<<<<< HEAD
        LoginController login = ctx.getBean(LoginController.class);
        
        login.showLogForm("login");
        
        //Tester t = ctx.getBean(Tester.class);
        //t.print();
        
        //new Prihlaseni().setVisible(true);
=======
        LoginController l = ctx.getBean(LoginController.class);
        l.showLogForm(null);
        
>>>>>>> 819b6fbc00aeafacf90cd397be0d059bd461db1e
    }
}
