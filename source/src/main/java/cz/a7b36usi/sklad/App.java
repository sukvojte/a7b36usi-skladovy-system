package cz.a7b36usi.sklad;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cz.a7b36usi.sklad.Controller.LoginController;


/**
 * Hello world!
 *
 */


public class App 
{
	
    
    public static void main( String[] args )
    {
    	
    	System.setProperty("log4j.configuration", new File(".", "log4j.xml").toURI().toString());

    	Logger logger = Logger.getLogger(App.class);
    	logger.debug("Starting application");
    	
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");

        LoginController login = ctx.getBean(LoginController.class);
        
        login.showLogForm("login");

    }
}
