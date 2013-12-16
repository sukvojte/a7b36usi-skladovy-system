
package cz.a7b36usi.sklad.Service;

import cz.a7b36usi.sklad.DTO.ProductDTO;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lukas L.
 */
public interface IProductService {
    /**
     * Persists product to database
     * @param jmeno
     * @param kod
     * @param mnozstvi
     * @return 
     */
    public Long addProduct(String jmeno, String kod, Integer mnozstvi);
    
    public void deleteProduct(Long produktId);
    
    @Transactional(readOnly=true)
    public List<ProductDTO> getAllProdukcs();
    
    boolean updateProduct(ProductDTO user);
}
