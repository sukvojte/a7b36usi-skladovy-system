package cz.a7b36usi.sklad;

import cz.a7b36usi.gui.Prihlaseni;
import cz.a7b36usi.sklad.BO.Test;
import cz.a7b36usi.sklad.BO.Tester;
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
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
//        
//        Tester t = ctx.getBean(Tester.class);
//        t.print();
        
        new Prihlaseni().setVisible(true);
    }
}
