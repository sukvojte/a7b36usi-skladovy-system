
package cz.a7b36usi.sklad.Service;

import cz.a7b36usi.sklad.DTO.ProduktDTO;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lukas L.
 */
public interface IProduktService {
    
    public Long addProdukt(String jmeno, String kod, Integer mnozstvi);
    
    public void deleteProdukt(Long produktId);
    
    @Transactional(readOnly=true)
    public List<ProduktDTO> getAllProdukts();
    
    boolean updateProdukt(ProduktDTO user);
}
