
package cz.a7b36usi.sklad.validators;

/**
 *
 * @author Lukas Lowinger
 */
public class CustomValidator {
    public static boolean longValidate(String s ){
	try{
	Long.parseLong(s);
	}
	catch(Exception e){
	    return false;
	}
	return true;
    }
    
    public static boolean integerValidate(String s ){
	try{
	Integer.parseInt(s);
	}
	catch(Exception e){
	    return false;
	}
	return true;
    }
}
