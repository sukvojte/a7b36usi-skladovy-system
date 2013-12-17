
package cz.a7b36usi.sklad.testy;

import cz.a7b36usi.sklad.DTO.CategoryDTO;
import cz.a7b36usi.sklad.DTO.OrderDTO;
import cz.a7b36usi.sklad.DTO.OrderItemDTO;
import cz.a7b36usi.sklad.DTO.PartnerDTO;
import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.Service.IOrderService;
import cz.a7b36usi.sklad.Service.IPartnerService;
import cz.a7b36usi.sklad.Service.IProductService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Lukas L.
 */
public class OrderServiceTest  extends AbstractServiceTest{
    
    @Autowired
    IOrderService orderService;
    
    @Autowired
    IPartnerService partnerService;
        
    @Autowired
    IProductService productService;
    
    @Test
    public void testSaveOrderItemsAndGet (){
	Long partner = partnerService.addPartner(true, false, "dsfsdfsd", "fdsfsdf", "NEJAKA", 333, 222);
        PartnerDTO p1=partnerService.getAllPartners().get(0);
	Long cat = productService.saveCategory(new CategoryDTO(null, "NEJAKA KATEGORIE", null));
	Long product = productService.saveProduct(new ProductDTO(null, "PRODUKT1", "nakej posranej kod", 200, cat));
	List<OrderItemDTO> list = new ArrayList<OrderItemDTO>();
	list.add(new OrderItemDTO(null, product, 500, null, null, 0L));
	list.add(new OrderItemDTO(null, product, 700, null, null, 0L));
	
	Long order = orderService.saveOrder(new OrderDTO(null, new Date(), "aaaa", null, p1));
	orderService.saveOrderItem(new OrderItemDTO(null, product, 500, null, null, order));
	orderService.saveOrderItem(new OrderItemDTO(null, product, 500, null, null, order));
	
	int size = orderService.getAllOrderItems(new OrderDTO(order, null, null, null, null)).size();
	assertEquals(2, size);
    }
    
    @Test
    public void test(){
	
    }
    
}
