package cz.a7b36usi.sklad.DTO;

import java.util.List;

/**
 *
 * @author Lukas L.
 */
public class DruhBaleniDTO extends AbstractDTO {

    private String nazev;
    private Double pocet;
    private Long produkt;
    private List<Long> objednavky;
    private List<Long> pohyby;

    public DruhBaleniDTO(String nazev, Double pocet, Long produkt, List<Long> objednavky, List<Long> pohyby) {
        this.nazev = nazev;
        this.pocet = pocet;
        this.produkt = produkt;
        this.objednavky = objednavky;
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
