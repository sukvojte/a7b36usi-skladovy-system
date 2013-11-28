
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
}
