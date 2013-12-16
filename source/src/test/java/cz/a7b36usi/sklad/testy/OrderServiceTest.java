
package cz.a7b36usi.sklad.testy;

import cz.a7b36usi.sklad.DTO.OrderDTO;
import cz.a7b36usi.sklad.DTO.OrderItemDTO;
import cz.a7b36usi.sklad.Service.IOrderService;
import cz.a7b36usi.sklad.Service.IPartnerService;
import java.util.Date;
import org.junit.Test;
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
    @Test
    public void test1 (){
	Long partner = partnerService.addPartner(true, false, "dsfsdfsd", "fdsfsdf", "NEJAKA", 333, 222);
	Long order = orderService.saveOrder(new OrderDTO(null, new Date(), null, partner));
	orderService.saveOrderItem(new OrderItemDTO(null, null, 500, null, null, order));
	System.out.println("order : "+order);
    }
}
