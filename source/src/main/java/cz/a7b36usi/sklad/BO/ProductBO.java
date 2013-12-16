package cz.a7b36usi.sklad.BO;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Lukas L.
 */
@Entity
@Table(name="product")
public class ProductBO extends AbstractBO {

    private String name;
    
    private String code;
    
    private Integer quantity;
    
    @ManyToOne
    private CategoryBO category;
    

 

//    public List<MovementBO> getPohyby() {
//        return pohyby;
//    }
//
//    public void setPohyby(List<MovementBO> pohyby) {
//        this.pohyby = pohyby;
//    }
//
//    public List<ProductVersionBO> getSarze() {
//        return sarze;
//    }
//
//    public void setSarze(List<ProductVersionBO> sarze) {
//        this.sarze = sarze;
//    }
//
//    public List<WrappingTypeBO> getDruhyBaleni() {
//        return druhyBaleni;
//    }
//
//    public void setDruhyBaleni(List<WrappingTypeBO> druhyBaleni) {
//        this.druhyBaleni = druhyBaleni;
//    }
//
//    public List<OrderItemBO> getPolozky() {
//        return polozky;
//    }
//
//    public void setPolozky(List<OrderItemBO> polozky) {
//        this.polozky = polozky;
//    }

//    @OneToMany(cascade = {CascadeType.ALL})
//    private List<MovementBO> pohyby;
//
//    @OneToMany(cascade = {CascadeType.ALL})
//    private List<ProductVersionBO> sarze;
//
//    @OneToMany(cascade = {CascadeType.ALL})
//    private List<WrappingTypeBO> druhyBaleni;
//
//    @OneToMany(cascade = {CascadeType.ALL})
//    private List<OrderItemBO> polozky;
//    public void addPohyb(MovementBO pohyb){
//        if(pohyby == null){
//            pohyby = new ArrayList<MovementBO>();
//        }
//        if(!pohyby.contains(pohyb)){
//            pohyby.add(pohyb);
//        }
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CategoryBO getCategory() {
        return category;
    }

    public void setCategory(CategoryBO category) {
        this.category = category;
    }
}
