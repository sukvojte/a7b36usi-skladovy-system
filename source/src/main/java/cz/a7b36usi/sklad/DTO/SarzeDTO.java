
package cz.a7b36usi.sklad.DTO;

import java.util.List;

/**
 *
 * @author Lukas L.
 */
public class SarzeDTO extends AbstractDTO{
    private Long kod;
    private String nazev;
    
    private Long produkt;
    
    private List<Long> objednavky;
    
    private List<Long> pohyby;

    public SarzeDTO(Long kod, String nazev, Long produkt, List<Long> objednavky, List<Long> pohyby) {
        this.kod = kod;
        this.nazev = nazev;
        this.produkt = produkt;
        this.objednavky = objednavky;
        this.pohyby = pohyby;
    }
    

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

    public Long getProdukt() {
        return produkt;
    }

    public void setProdukt(Long produkt) {
        this.produkt = produkt;
    }

    public List<Long> getObjednavky() {
        return objednavky;
    }

    public void setObjednavky(List<Long> objednavky) {
        this.objednavky = objednavky;
    }

    public List<Long> getPohyby() {
        return pohyby;
    }

    public void setPohyby(List<Long> pohyby) {
        this.pohyby = pohyby;
    }
    
    
}
