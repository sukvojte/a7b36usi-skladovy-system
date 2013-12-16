package cz.a7b36usi.sklad.Service;

import cz.a7b36usi.sklad.BO.CategoryBO;
import cz.a7b36usi.sklad.BO.ProductBO;
import cz.a7b36usi.sklad.DTO.CategoryDTO;
import cz.a7b36usi.sklad.DTO.ProductDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lukas L.
 */
public class ProductService extends AbstractService implements IProductService {

    public Long saveProduct(ProductDTO product) {
        ProductBO bo = new ProductBO();
        bo.setCategory(genericDAO.loadById(product.getCategory(), CategoryBO.class));
        bo.setCode(product.getCode());
        bo.setName(product.getName());
        bo.setQuantity(product.getQuantity());
        bo.setId(product.getId());
        return genericDAO.saveOrUpdate(bo).getId();
    }

    public void deleteProduct(Long productId) {
        genericDAO.removeById(productId, ProductBO.class);
    }

    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> dtos = new ArrayList<ProductDTO>();
        List<ProductBO> bos = genericDAO.getAll(ProductBO.class);
        for (ProductBO bo : bos) {
            ProductDTO dto = new ProductDTO(bo.getId(), bo.getName(), bo.getCode(), bo.getQuantity(), bo.getCategory().getId());
            dtos.add(dto);
        }
        return dtos;
    }

    public Long saveCategory(CategoryDTO category) {
        CategoryBO bo = new CategoryBO();
        bo.setId(category.getId());
        bo.setName(category.getName());
        bo.setParrent(null);
        return genericDAO.saveOrUpdate(bo).getId();
    }

    public void removeCategory(Long categoryId) {
        genericDAO.removeById(categoryId, CategoryBO.class);
    }

    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> dtos = new ArrayList<CategoryDTO>();
        List<CategoryBO> bos = genericDAO.getAll(CategoryBO.class);
        for (CategoryBO bo : bos) {
           CategoryDTO dto = new CategoryDTO(bo.getId(), bo.getName(), bo.getParrent().getId());
           dtos.add(dto);
        }
        return dtos;
    }

}
