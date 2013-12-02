package cz.a7b36usi.sklad.BO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Lukas L.
 */
@Entity
public class ProduktBO extends AbstractBO {

    private String jmeno;
    
    private String kod;
    
    private Integer mnozstvi;
    
    @ManyToOne
    private KategorieBO kategorie;
    
    @OneToMany(cascade = {CascadeType.ALL})
    private List<PohybBO> pohyby;
    
    @OneToMany(cascade = {CascadeType.ALL})
    private List<SarzeBO> sarze;
    
    @OneToMany(cascade = {CascadeType.ALL})
    private List<DruhBaleniBO> druhyBaleni;
    
    @OneToMany(cascade = {CascadeType.ALL})
    private List<PolozkaBO> polozky;
    
    public void addPohyb(PohybBO pohyb){
        if(pohyby == null){
            pohyby = new ArrayList<PohybBO>();
        }
        if(!pohyby.contains(pohyb)){
            pohyby.add(pohyb);
        }
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

    public KategorieBO getKategorie() {
        return kategorie;
    }

    public void setKategorie(KategorieBO kategorie) {
        this.kategorie = kategorie;
    }

    public List<PohybBO> getPohyby() {
        return pohyby;
    }

    public void setPohyby(List<PohybBO> pohyby) {
        this.pohyby = pohyby;
    }

    public List<SarzeBO> getSarze() {
        return sarze;
    }

    public void setSarze(List<SarzeBO> sarze) {
        this.sarze = sarze;
    }

    public List<DruhBaleniBO> getDruhyBaleni() {
        return druhyBaleni;
    }

    public void setDruhyBaleni(List<DruhBaleniBO> druhyBaleni) {
        this.druhyBaleni = druhyBaleni;
    }

    public List<PolozkaBO> getPolozky() {
        return polozky;
    }

    public void setPolozky(List<PolozkaBO> polozky) {
        this.polozky = polozky;
    }
}
