/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.BO;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Peter
 */

/**
 * Entita ktera slouzi pro uchovani informace o poctu pruduktu v jedne objednavce
 */
@Entity
@Table(name="article")
public class ArticleBO extends AbstractBO{
    
    @ManyToOne
    private ProductBO produkt;
    
    private int quantity;

    public ProductBO getProdukt() {
        return produkt;
    }

    public ArticleBO() {
    }

    //***************** GETTER SETTER KILOMETER BY PETER ********************************
    
    
    public void setProdukt(ProductBO produkt) {
        this.produkt = produkt;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
}
