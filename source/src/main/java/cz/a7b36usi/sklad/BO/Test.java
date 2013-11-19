/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.BO;

import org.springframework.stereotype.Component;
import cz.a7b36usi.sklad.BO.ITest;

/**
 *
 * @author Peter
 */
@Component
public class Test implements ITest{
    String s;
    
    Test(){
    this.s = "Test";
    }
    
    public void print(){
        System.out.println(s);
    }
}
