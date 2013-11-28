
package cz.a7b36usi.sklad.BO;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Lukas L.
 */
@Entity
public class SarzeBO extends AbstractBO{
    private Long kod;
    private String nazev;
    
    @ManyToOne
    private ProduktBO produkt;
    
    @OneToMany
    private List<ObjednavkaBO> objednavky;
    
    @OneToMany
    private List<PohybBO> pohyby;
    
}
