
package cz.a7b36usi.sklad.BO;

import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author Lukas L.
 */
@Entity
public class KategorieBO extends AbstractBO{
    
    private String jmeno;
    
    private List<KategorieBO> podkategorie;
}
