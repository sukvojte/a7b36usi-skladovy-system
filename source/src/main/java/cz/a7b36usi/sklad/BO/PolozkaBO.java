/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.BO;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Peter
 */

/**
 * Entita ktera slouzi pro uchovani informace o poctu pruduktu v jedne objednavce
 */
@Entity
public class PolozkaBO extends AbstractBO{
    
    @ManyToOne
    private ProduktBO produkt;
    
    private int quantity;

    public ProduktBO getProdukt() {
        return produkt;
    }

    public PolozkaBO() {
    }

    //***************** GETTER SETTER KILOMETER BY PETER ********************************
    
    
    public void setProdukt(ProduktBO produkt) {
        this.produkt = produkt;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
}
