
package cz.a7b36usi.sklad.BO;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Lukas L.
 */
@Entity
@Table(name="wrapping_type")
public class WrappingTypeBO extends AbstractBO{
    private String name;
    private Double quantity;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private ProductBO product;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public ProductBO getProduct() {
        return product;
    }

    public void setProduct(ProductBO product) {
        this.product = product;
    }
    
    
    


    
    
}
