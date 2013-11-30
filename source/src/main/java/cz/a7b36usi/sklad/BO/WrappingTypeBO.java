
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
@Table(name="wrapping_type")
public class WrappingTypeBO extends AbstractBO{
    private String nazev;
    private Double pocet;
    
    @ManyToOne
    private ProductBO produkt;
    
    @OneToMany
    private List<OrderBO> objednavky;
    
    @OneToMany
    private List<MovementBO> pohyby;

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

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public Double getPocet() {
        return pocet;
    }

    public void setPocet(Double pocet) {
        this.pocet = pocet;
    }
    
    
}
