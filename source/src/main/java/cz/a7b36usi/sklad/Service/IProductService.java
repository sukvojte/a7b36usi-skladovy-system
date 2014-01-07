package cz.a7b36usi.sklad.Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cz.a7b36usi.sklad.DTO.CategoryDTO;
import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.DTO.ProductVersionDTO;
import cz.a7b36usi.sklad.DTO.WrappingTypeDTO;

/**
 *
 * @author Lukas L.
 */
public interface IProductService {

    /**
     * Persists product to database. If id is null, then new product will be
     * created in database
     *
     * @param product
     * @return
     */
    public Long saveProduct(ProductDTO product);

    /**
     * Removes product from database
     *
     * @param produktId identifier of product to be removed
     */
    public void deleteProduct(Long produktId);

    /**
     * Persists category into database. If identifier is null, then new category
     * will be created. Note: parrent category is set to null no matter what is
     * in DTO param, so tree structure is not implemented yet
     *
     * @param category
     * @return
     */
    public Long saveCategory(CategoryDTO category);

    /**
     * Removes category from database
     *
     * @param categoryId identifier of category to be removed
     */
    public void removeCategory(Long categoryId);

    /**
     *
     * @return all products from database
     */
    @Transactional(readOnly = true)
    public List<ProductDTO> getAllProducts();

    /**
     *
     * @return all categories from database
     */
    @Transactional(readOnly = true)
    public List<CategoryDTO> getAllCategories();

    /**
     *
     * Persist wrapping type into database. If id is null, then new wrapping
     * type will be created
     *
     * @param wrap wrapping type to be persisted
     * @return identifier of persisted wrapping type
     */
    public Long saveWrappingType(WrappingTypeDTO wrap);

    /**
     * removes wrapping type from database
     *
     * @param id identifier of wrapping type to be removed
     */
    public void removeWrappingType(Long id);

    /**
     *
     * @return all wrapping types
     */
    @Transactional(readOnly = true)
    public List<WrappingTypeDTO> getAllWrappingTypes();

    /**
     *
     * @param productId identifier of product
     * @return all wrapping types of one product
     */
    @Transactional(readOnly = true)
    public List<WrappingTypeDTO> getAllWrappingTypesByProduct(Long productId);

    /**
     *
     * Persist version into database. If id is null, then new version will be
     * created
     *
     * @param version version to be persisted
     * @return identifier of persisted version
     */
    public Long saveProductVersion(ProductVersionDTO version);

    /**
     * removes version from database
     *
     * @param id identifier of version to be removed
     */
    public void removeProductVersion(Long id);

    /**
     *
     * @return all product versions
     */
    public List<ProductVersionDTO> getAllProductVersions();
    
        /**
     *
     * @param productId identifier of product
     * @return all product versions of one product
     */
    @Transactional(readOnly = true)
    public List<ProductVersionDTO> getAllProductVersionsByProduct(Long productId);


}
