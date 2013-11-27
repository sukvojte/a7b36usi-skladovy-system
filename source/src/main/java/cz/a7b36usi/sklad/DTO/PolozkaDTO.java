/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.DTO;

/**
 *
 * @author Peter
 */
public class PolozkaDTO extends AbstractDTO{
     private Long produkt;
    
    private int quantity;

    public PolozkaDTO(Long id,Long produkt, int quantity) {
        this.produkt = produkt;
        this.quantity = quantity;
        this.id=id;
    }

    

    //***************** GETTER SETTER KILOMETER BY PETER ********************************
    public Long getProdukt() {
        return produkt;
    }
    
    public void setProdukt(Long produkt) {
        this.produkt = produkt;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
