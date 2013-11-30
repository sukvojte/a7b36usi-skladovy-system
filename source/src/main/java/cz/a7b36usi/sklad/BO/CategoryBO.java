
package cz.a7b36usi.sklad.BO;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Lukas L.
 */
@Entity
@Table(name="category")
public class CategoryBO extends AbstractBO{
    
    private String jmeno;
    
    @OneToMany(cascade = {CascadeType.ALL})
    private List<CategoryBO> podkategorie;
    
    @OneToMany(cascade = {CascadeType.ALL})
    private List<ProductBO> jeVProduktech;

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public List<CategoryBO> getPodkategorie() {
        return podkategorie;
    }

    public void setPodkategorie(List<CategoryBO> podkategorie) {
        this.podkategorie = podkategorie;
    }

    public List<ProductBO> getJeVProduktech() {
        return jeVProduktech;
    }

    public void setJeVProduktech(List<ProductBO> jeVProduktech) {
        this.jeVProduktech = jeVProduktech;
    }
        
    
}
