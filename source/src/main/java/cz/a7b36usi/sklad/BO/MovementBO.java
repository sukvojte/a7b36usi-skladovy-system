/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.BO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Peter
 */

/**
 * Entity representing movement of one product
 */
@Entity
@Table(name = "movement")
public class MovementBO extends AbstractBO {

    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(nullable = true)
    private WrappingTypeBO wrapping;

    @ManyToOne
    @JoinColumn(nullable = true)
    private ProductVersionBO version;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ProductBO product;

    @ManyToOne
    @JoinColumn(nullable = false)
    private DocumentBO document;

    public MovementBO() {
    }

    //***************** GETTER SETTER KILOMETER BY PETER ********************************
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public WrappingTypeBO getWrapping() {
        return wrapping;
    }

    public void setWrapping(WrappingTypeBO wrapping) {
        this.wrapping = wrapping;
    }

    public ProductVersionBO getVersion() {
        return version;
    }

    public void setVersion(ProductVersionBO version) {
        this.version = version;
    }

    public ProductBO getProdukt() {
        return product;
    }

    public void setProdukt(ProductBO product) {
        this.product = product;
    }

    public DocumentBO getDocument() {
        return document;
    }

    public void setDocument(DocumentBO document) {
        this.document = document;
    }


}
