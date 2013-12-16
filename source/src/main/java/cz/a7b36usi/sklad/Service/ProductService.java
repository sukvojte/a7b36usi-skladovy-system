
package cz.a7b36usi.sklad.Service;

import cz.a7b36usi.sklad.BO.ProductBO;
import cz.a7b36usi.sklad.DTO.ProductDTO;
import java.util.List;

/**
 *
 * @author Lukas L.
 */
public class ProductService extends AbstractService implements IProductService{

    public Long addProduct(String jmeno, String kod, Integer mnozstvi) {
	ProductBO product = new ProductBO();
	product.setJmeno(jmeno);
	product.setKod(kod);
	product.setMnozstvi(mnozstvi);
	return genericDAO.saveOrUpdate(product).getId();
    }

    public void deleteProduct(Long produktId) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<ProductDTO> getAllProdukcs() {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean updateProduct(ProductDTO user) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

}
