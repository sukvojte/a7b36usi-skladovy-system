
package cz.a7b36usi.sklad.DTO;

import java.util.List;

/**
 *
 * @author Lukas L.
 */
public class KategorieDTO extends AbstractDTO{
    
    private String jmeno;
    
    private List<Long> podkategorie;
    
    private List<Long> jeVProduktech;

    public KategorieDTO(String jmeno, List<Long> podkategorie, List<Long> jeVProduktech) {
        this.jmeno = jmeno;
        this.podkategorie = podkategorie;
        this.jeVProduktech = jeVProduktech;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public List<Long> getPodkategorie() {
        return podkategorie;
    }

    public void setPodkategorie(List<Long> podkategorie) {
        this.podkategorie = podkategorie;
    }

    public List<Long> getJeVProduktech() {
        return jeVProduktech;
    }

    public void setJeVProduktech(List<Long> jeVProduktech) {
        this.jeVProduktech = jeVProduktech;
    }
    
    
}
