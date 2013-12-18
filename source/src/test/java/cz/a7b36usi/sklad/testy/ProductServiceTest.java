/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.a7b36usi.sklad.testy;

import cz.a7b36usi.sklad.DTO.CategoryDTO;
import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.DTO.ProductVersionDTO;
import cz.a7b36usi.sklad.DTO.WrappingTypeDTO;
import cz.a7b36usi.sklad.Service.IProductService;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;


public class ProductServiceTest extends AbstractServiceTest{
    @Autowired
    IProductService productService;
    
    
    
    @Test
    public void saveProduct(){
        CategoryDTO cat=new CategoryDTO(null,"jidlo",null);
        Long catId=productService.saveCategory(cat);
        ProductDTO pr=new ProductDTO(null,"kase","FGSVRI",Integer.valueOf(12),catId);
        Long prodId=productService.saveProduct(pr);
        List<ProductDTO> list=productService.getAllProducts();
        boolean isObjDetected=false;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(prodId)){
                isObjDetected=true;
                pr=list.get(i);
            }
            
        }
        assertTrue(isObjDetected);
        assertEquals(prodId,pr.getId());
        assertEquals("kase",pr.getName());
        assertEquals("FGSVRI",pr.getCode());
        assertEquals(Integer.valueOf(12),pr.getQuantity());
        assertEquals(catId,pr.getCategory());
    }
    @Test
    public void deleteProduct(){
        CategoryDTO cat=new CategoryDTO(null,"jidlo",null);
        Long catId=productService.saveCategory(cat);
        ProductDTO pr=new ProductDTO(null,"kase","FGSVRI",Integer.valueOf(12),catId);
        Long prodId=productService.saveProduct(pr);
        productService.deleteProduct(prodId);
        List<ProductDTO> list=productService.getAllProducts();
        boolean isObjDetected=false;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(prodId)){
                isObjDetected=true;
            }
            
        }
        assertFalse(isObjDetected);
    }
    @Test
    public void saveCategory(){
        CategoryDTO cat=new CategoryDTO(null,"jidlo",null);
        Long catId=productService.saveCategory(cat);
        List<CategoryDTO> list=productService.getAllCategories();
        boolean isObjDetected=false;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(catId)){
                isObjDetected=true;
                cat=list.get(i);
            }
            
        }
        assertTrue(isObjDetected);
        
        assertEquals(catId,cat.getId());
        assertEquals("jidlo",cat.getName());
        assertNull(cat.getParrent());
    }
    @Test
    public void removeCategory(){
        CategoryDTO cat=new CategoryDTO(null,"jidlo",null);
        Long catId=productService.saveCategory(cat);
        List<CategoryDTO> list=productService.getAllCategories();
        productService.removeCategory(catId);
        boolean isObjDetected=false;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(catId)){
                isObjDetected=true;
            }
            
        }
        assertFalse(isObjDetected);
    }
    @Test
    public void getAllProducts(){
        
    }
    @Test
    public void getAllCategories(){
        
    }
    @Test
    public void saveWrappingType(){
        
    }
    @Test
    public void removeWrappingType(){
        
    }
    @Test
    public void getAllWrappingTypes(){
        
    }
    @Test
    public void saveProductVersion(){
        
    }
    @Test
    public void removeProductVersion(){
        
    }
    @Test
    public void getAllProductVersions(){
        
    }
}
