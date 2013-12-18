package cz.a7b36usi.sklad.Service;

import cz.a7b36usi.sklad.BO.CategoryBO;
import cz.a7b36usi.sklad.BO.ProductBO;
import cz.a7b36usi.sklad.BO.ProductVersionBO;
import cz.a7b36usi.sklad.BO.WrappingTypeBO;
import cz.a7b36usi.sklad.DTO.CategoryDTO;
import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.DTO.ProductVersionDTO;
import cz.a7b36usi.sklad.DTO.WrappingTypeDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Lukas L.
 */
@Component
public class ProductService extends AbstractService implements IProductService {

    public Long saveProduct(ProductDTO product) {
        ProductBO bo = new ProductBO();
        bo.setCategory(product.getCategory() != null ? genericDAO.loadById(product.getCategory(), CategoryBO.class) : null);
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
            ProductDTO dto = new ProductDTO(bo.getId(), bo.getName(), bo.getCode(), bo.getQuantity(), (bo.getCategory() != null ? bo.getCategory().getId() : 0));
            dtos.add(dto);
        }
        return dtos;
    }

    public Long saveCategory(CategoryDTO category) {
        CategoryBO bo = new CategoryBO();
        bo.setId(category.getId());
        bo.setName(category.getName());
        
        bo.setParrent(category.getParrent()!=null ? genericDAO.getById(category.getParrent(), CategoryBO.class) : null);
        return genericDAO.saveOrUpdate(bo).getId();
    }

    public void removeCategory(Long categoryId) {        
        genericDAO.removeById(categoryId, CategoryBO.class);
    }

    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> dtos = new ArrayList<CategoryDTO>();
        List<CategoryBO> bos = genericDAO.getAll(CategoryBO.class);
        for (CategoryBO bo : bos) {
            CategoryDTO dto = new CategoryDTO(bo.getId(), bo.getName(), (bo.getParrent() != null?bo.getParrent().getId():null));
            dtos.add(dto);
        }
        return dtos;
    }

    public Long saveWrappingType(WrappingTypeDTO wrap) {
        WrappingTypeBO bo = new WrappingTypeBO();
        bo.setId(wrap.getId());
        bo.setName(wrap.getName());
        bo.setQuantity(wrap.getQuantity());
        bo.setProduct(genericDAO.loadById(wrap.getProduct(), ProductBO.class));
        return genericDAO.saveOrUpdate(bo).getId();
    }

    public void removeWrappingType(Long id) {
        genericDAO.removeById(id, WrappingTypeBO.class);
    }

    public List<WrappingTypeDTO> getAllWrappingTypes() {
        List<WrappingTypeDTO> dtos = new ArrayList<WrappingTypeDTO>();
        List<WrappingTypeBO> bos = genericDAO.getAll(WrappingTypeBO.class);
        for (WrappingTypeBO bo : bos) {
            WrappingTypeDTO dto = new WrappingTypeDTO(bo.getId(), bo.getName(), bo.getQuantity(), bo.getProduct().getId());
            dtos.add(dto);
        }
        return dtos;
    }

    public Long saveProductVersion(ProductVersionDTO version) {
        ProductVersionBO bo = new ProductVersionBO();
        bo.setCode(version.getCode());
        bo.setName(version.getName());
        bo.setId(version.getId());
        bo.setProduct(genericDAO.loadById(version.getProduct(), ProductBO.class));
        return genericDAO.saveOrUpdate(bo).getId();
    }

    public void removeProductVersion(Long id) {
        genericDAO.removeById(id, ProductVersionBO.class);
    }

    public List<ProductVersionDTO> getAllProductVersions() {
        List<ProductVersionDTO> dtos = new ArrayList<ProductVersionDTO>();
        List<ProductVersionBO> bos = genericDAO.getAll(ProductVersionBO.class);
        for (ProductVersionBO bo : bos) {
            ProductVersionDTO dto = new ProductVersionDTO(bo.getId(), bo.getCode(), bo.getName(), bo.getProduct().getId());
            dtos.add(dto);
        }
        return dtos;
    }

}
