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
    public void saveAndGetAllProducts(){
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
    public void saveAndGetAllCategories(){
        CategoryDTO cat=new CategoryDTO(null,"jiidlo",null);
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
        assertEquals("jiidlo",cat.getName());
        assertNull(cat.getParrent());
    }
    @Test
    public void removeCategory(){
        CategoryDTO cat=new CategoryDTO(null,"jidlo",null);
        Long catId=productService.saveCategory(cat);
        productService.removeCategory(catId);
        List<CategoryDTO> list=productService.getAllCategories();
        boolean isObjDetected=false;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(catId)){
                isObjDetected=true;
            }
            
        }
        assertFalse(isObjDetected);
    }

    
    @Test
    public void saveAndGetAllWrappingTypes(){
         CategoryDTO cat=new CategoryDTO(null,"jidlo",null);
        Long catId=productService.saveCategory(cat);
        ProductDTO pr=new ProductDTO(null,"kase","FGSVRI",Integer.valueOf(12),catId);
        Long prodId=productService.saveProduct(pr);
        WrappingTypeDTO wrp=new WrappingTypeDTO(null,"box",30.0,prodId);
        Long wrapID=productService.saveWrappingType(wrp);
        
        List<WrappingTypeDTO> wrap_list=productService.getAllWrappingTypes();
        boolean isObjDetected=false;
        for (int i = 0; i < wrap_list.size(); i++) {
            if(wrap_list.get(i).getId().equals(wrapID)){
                isObjDetected=true;
                wrp=wrap_list.get(i);
            }
            
        }
        assertTrue(isObjDetected);
        assertEquals(wrapID,wrp.getId());
        assertEquals("box",wrp.getName());
        assertTrue(wrp.getQuantity()==30.0);
        assertEquals(prodId,wrp.getProduct());
    }
    @Test
    public void removeWrappingType(){
        CategoryDTO cat=new CategoryDTO(null,"jidlo",null);
        Long catId=productService.saveCategory(cat);
        ProductDTO pr=new ProductDTO(null,"kase","FGSVRI",Integer.valueOf(12),catId);
        Long prodId=productService.saveProduct(pr);
        WrappingTypeDTO wrp=new WrappingTypeDTO(null,"box",30.0,prodId);
        Long wrapID=productService.saveWrappingType(wrp);
        productService.removeWrappingType(wrapID);
        List<WrappingTypeDTO> wrap_list=productService.getAllWrappingTypes();
        boolean isObjDetected=false;
        for (int i = 0; i < wrap_list.size(); i++) {
            if(wrap_list.get(i).getId().equals(wrapID)){
                isObjDetected=true;
            }
            
        }
        assertFalse(isObjDetected);
    }
    
    @Test
    public void saveAndGetAllProductVersions(){
        CategoryDTO cat=new CategoryDTO(null,"jidlo",null);
        Long catId=productService.saveCategory(cat);
        ProductDTO pr=new ProductDTO(null,"kase","FGSVRI",Integer.valueOf(12),catId);
        Long prodId=productService.saveProduct(pr);
        ProductVersionDTO prV=new ProductVersionDTO(null,Long.valueOf(1434),"verze 1", prodId);
        Long versId=productService.saveProductVersion(prV);
        
        List<ProductVersionDTO> vers_list=productService.getAllProductVersions();
        boolean isObjDetected=false;
        for (int i = 0; i < vers_list.size(); i++) {
             if(vers_list.get(i).getId().equals(versId)){
                isObjDetected=true;
                prV=vers_list.get(i);
            }
            
        }
        assertTrue(isObjDetected);
        assertEquals(versId,prV.getId());
        assertEquals(Long.valueOf(1434),prV.getCode());
        assertEquals("verze 1",prV.getName());
        assertEquals(prodId,prV.getProduct());
        
    }
    @Test
    public void removeProductVersion(){
        CategoryDTO cat=new CategoryDTO(null,"jidlo",null);
        Long catId=productService.saveCategory(cat);
        ProductDTO pr=new ProductDTO(null,"kase","FGSVRI",Integer.valueOf(12),catId);
        Long prodId=productService.saveProduct(pr);
        ProductVersionDTO prV=new ProductVersionDTO(null,Long.valueOf(1434),"verze 1", prodId);
        Long versId=productService.saveProductVersion(prV);
        productService.removeProductVersion(versId);
        List<ProductVersionDTO> vers_list=productService.getAllProductVersions();
        boolean isObjDetected=false;
        for (int i = 0; i < vers_list.size(); i++) {
             if(vers_list.get(i).getId().equals(versId)){
                isObjDetected=true;
            }
            
        }
        assertFalse(isObjDetected);
    }
}
