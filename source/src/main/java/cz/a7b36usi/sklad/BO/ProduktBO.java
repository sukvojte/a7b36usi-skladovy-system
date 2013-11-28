
package cz.a7b36usi.sklad.BO;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.ManyToAny;

/**
 *
 * @author Lukas L.
 */
@Entity
public class ProduktBO extends AbstractBO{
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
    
}
