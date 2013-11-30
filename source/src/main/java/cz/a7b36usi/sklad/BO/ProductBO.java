package cz.a7b36usi.sklad.BO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ManyToAny;

/**
 *
 * @author Lukas L.
 */
@Entity
@Table(name="product")
public class ProductBO extends AbstractBO {

    private String jmeno;
    
    private String kod;
    
    private Integer mnozstvi;
    
    @ManyToOne
    private CategoryBO kategorie;
    
    @OneToMany(cascade = {CascadeType.ALL})
    private List<MovementBO> pohyby;
    
    @OneToMany(cascade = {CascadeType.ALL})
    private List<ProductVersionBO> sarze;
    
    @OneToMany(cascade = {CascadeType.ALL})
    private List<WrappingTypeBO> druhyBaleni;
    
    @OneToMany(cascade = {CascadeType.ALL})
    private List<ArticleBO> polozky;
    
    public void addPohyb(MovementBO pohyb){
        if(pohyby == null){
            pohyby = new ArrayList<MovementBO>();
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

    public CategoryBO getKategorie() {
        return kategorie;
    }

    public void setKategorie(CategoryBO kategorie) {
        this.kategorie = kategorie;
    }

    public List<MovementBO> getPohyby() {
        return pohyby;
    }

    public void setPohyby(List<MovementBO> pohyby) {
        this.pohyby = pohyby;
    }

    public List<ProductVersionBO> getSarze() {
        return sarze;
    }

    public void setSarze(List<ProductVersionBO> sarze) {
        this.sarze = sarze;
    }

    public List<WrappingTypeBO> getDruhyBaleni() {
        return druhyBaleni;
    }

    public void setDruhyBaleni(List<WrappingTypeBO> druhyBaleni) {
        this.druhyBaleni = druhyBaleni;
    }

    public List<ArticleBO> getPolozky() {
        return polozky;
    }

    public void setPolozky(List<ArticleBO> polozky) {
        this.polozky = polozky;
    }
}
