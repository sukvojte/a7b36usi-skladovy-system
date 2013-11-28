
package cz.a7b36usi.sklad.BO;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Lukas L.
 */
@Entity
public class DruhBaleniBO extends AbstractBO{
    private String nazev;
    private Double pocet;
    
    @ManyToOne
    private ProduktBO produkt;
    
    @OneToMany
    private List<ObjednavkaBO> objednavky;
    
    @OneToMany
    private List<PohybBO> pohyby;

    public ProduktBO getProdukt() {
        return produkt;
    }

    public void setProdukt(ProduktBO produkt) {
        this.produkt = produkt;
    }

    public List<ObjednavkaBO> getObjednavky() {
        return objednavky;
    }

    public void setObjednavky(List<ObjednavkaBO> objednavky) {
        this.objednavky = objednavky;
    }

    public List<PohybBO> getPohyby() {
        return pohyby;
    }

    public void setPohyby(List<PohybBO> pohyby) {
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
