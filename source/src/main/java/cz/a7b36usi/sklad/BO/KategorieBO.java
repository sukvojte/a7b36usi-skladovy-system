
package cz.a7b36usi.sklad.BO;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Lukas L.
 */
@Entity
public class KategorieBO extends AbstractBO{
    
    private String jmeno;
    
    @OneToMany(cascade = {CascadeType.ALL})
    private List<KategorieBO> podkategorie;
    
    @OneToMany(cascade = {CascadeType.ALL})
    private List<ProduktBO> jeVProduktech;

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public List<KategorieBO> getPodkategorie() {
        return podkategorie;
    }

    public void setPodkategorie(List<KategorieBO> podkategorie) {
        this.podkategorie = podkategorie;
    }

    public List<ProduktBO> getJeVProduktech() {
        return jeVProduktech;
    }

    public void setJeVProduktech(List<ProduktBO> jeVProduktech) {
        this.jeVProduktech = jeVProduktech;
    }
        
    
}
