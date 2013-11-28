
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
public class SarzeBO extends AbstractBO{
    private Long kod;
    private String nazev;
    
    @ManyToOne
    private ProduktBO produkt;
    
    @OneToMany
    private List<ObjednavkaBO> objednavky;
    
    @OneToMany
    private List<PohybBO> pohyby;

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
    
    
    
}
