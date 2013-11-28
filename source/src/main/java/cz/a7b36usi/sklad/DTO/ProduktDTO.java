package cz.a7b36usi.sklad.DTO;

import java.util.List;

/**
 *
 * @author Lukas L.
 */
public class ProduktDTO extends AbstractDTO {

    private String jmeno;
    private String kod;
    private Integer mnozstvi;
    private Long kategorie;
    private List<Long> pohyby;
    private List<Long> sarze;
    private List<Long> druhyBaleni;
    private List<Long> polozky;

    public ProduktDTO(String jmeno, String kod, Integer mnozstvi, Long kategorie, List<Long> pohyby, List<Long> sarze, List<Long> druhyBaleni, List<Long> polozky) {
        this.jmeno = jmeno;
        this.kod = kod;
        this.mnozstvi = mnozstvi;
        this.kategorie = kategorie;
        this.pohyby = pohyby;
        this.sarze = sarze;
        this.druhyBaleni = druhyBaleni;
        this.polozky = polozky;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public Integer getMnozstvi() {
        return mnozstvi;
    }

    public void setMnozstvi(Integer mnozstvi) {
        this.mnozstvi = mnozstvi;
    }

    public Long getKategorie() {
        return kategorie;
    }

    public void setKategorie(Long kategorie) {
        this.kategorie = kategorie;
    }

    public List<Long> getPohyby() {
        return pohyby;
    }

    public void setPohyby(List<Long> pohyby) {
        this.pohyby = pohyby;
    }

    public List<Long> getSarze() {
        return sarze;
    }

    public void setSarze(List<Long> sarze) {
        this.sarze = sarze;
    }

    public List<Long> getDruhyBaleni() {
        return druhyBaleni;
    }

    public void setDruhyBaleni(List<Long> druhyBaleni) {
        this.druhyBaleni = druhyBaleni;
    }

    public List<Long> getPolozky() {
        return polozky;
    }

    public void setPolozky(List<Long> polozky) {
        this.polozky = polozky;
    }
}
