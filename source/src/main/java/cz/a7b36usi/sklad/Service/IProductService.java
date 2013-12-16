package cz.a7b36usi.sklad.Service;

import cz.a7b36usi.sklad.DTO.CategoryDTO;
import cz.a7b36usi.sklad.DTO.ProductDTO;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

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
     * will be created. Note: parrent category is set to null no matter what is in DTO param, so tree structure is not implemented yet
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

}
