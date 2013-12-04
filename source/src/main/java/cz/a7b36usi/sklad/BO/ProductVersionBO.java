
package cz.a7b36usi.sklad.BO;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Lukas L.
 */
@Entity
@Table(name="product_version")
public class ProductVersionBO extends AbstractBO{
    private Long kod;
    private String nazev;
    
    @ManyToOne
    private ProductBO produkt;
    
    @OneToMany
    private List<OrderBO> objednavky;
    
    @OneToMany
    private List<MovementBO> pohyby;

    public Long getKod() {
        return kod;
    }

    public void setKod(Long kod) {
        this.kod = kod;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public ProductBO getProdukt() {
        return produkt;
    }

    public void setProdukt(ProductBO produkt) {
        this.produkt = produkt;
    }

    public List<OrderBO> getObjednavky() {
        return objednavky;
    }

    public void setObjednavky(List<OrderBO> objednavky) {
        this.objednavky = objednavky;
    }

    public List<MovementBO> getPohyby() {
        return pohyby;
    }

    public void setPohyby(List<MovementBO> pohyby) {
        this.pohyby = pohyby;
    }
    
    
    
}
