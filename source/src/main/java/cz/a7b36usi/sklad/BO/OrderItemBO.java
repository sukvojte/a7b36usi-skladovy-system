/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.BO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
public class OrderItemBO extends AbstractBO{
    
    @ManyToOne
    @Column(nullable = false)
    private ProductBO product;
    
    @Column(nullable = false)
    private int quantity;
    
    @Column(name = "wrapping",nullable = false)
    @ManyToOne
    private WrappingTypeBO wrappingType;
    
    @Column(name = "version",nullable = false)
    @ManyToOne
    private ProductVersionBO productVersion;
    
    @Column(name = "parrentOrder",nullable = false)
    @ManyToOne
    private OrderBO order;

   

    public OrderItemBO() {
    }

    //***************** GETTER SETTER KILOMETER BY PETER ********************************
    public ProductBO getProduct() {
        return product;
    }

    public void setProduct(ProductBO product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public WrappingTypeBO getWrappingType() {
        return wrappingType;
    }

    public void setWrappingType(WrappingTypeBO wrappingType) {
        this.wrappingType = wrappingType;
    }

    public ProductVersionBO getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(ProductVersionBO productVersion) {
        this.productVersion = productVersion;
    }

    public OrderBO getOrder() {
        return order;
    }

    public void setOrder(OrderBO order) {
        this.order = order;
    }
    
    

    
    
    
}
