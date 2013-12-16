/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.DTO;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Peter
 */
public class OrderDTO extends AbstractDTO {

    private Date date;

    private List<OrderItemDTO> items;

    private Long partner;
    
    private String number;

    
    /**
     * DTO representing order
     * @param id 
     * @param date date of creation (not the creation of the world, but creation of this order)
     * @param number identification number of this order (not database identifier)
     * @param items list of items contained in the order
     * @param partner   owner of this order
     */
    public OrderDTO(Long id, Date date,String number, List<OrderItemDTO> items, Long partner) {
        this.date = date;
        this.items = items;
        this.partner = partner;
        this.id = id;
        this.number=number;
    }

    //***************** GETTER SETTER KILOMETER BY PETER ********************************
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    public Long getPartner() {
        return partner;
    }

    public void setPartner(Long partner) {
        this.partner = partner;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
    
}
