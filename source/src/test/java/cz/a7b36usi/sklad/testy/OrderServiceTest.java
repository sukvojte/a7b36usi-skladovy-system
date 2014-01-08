package cz.a7b36usi.sklad.testy;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cz.a7b36usi.sklad.DTO.CategoryDTO;
import cz.a7b36usi.sklad.DTO.OrderDTO;
import cz.a7b36usi.sklad.DTO.OrderItemDTO;
import cz.a7b36usi.sklad.DTO.PartnerDTO;
import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.DTO.ProductVersionDTO;
import cz.a7b36usi.sklad.DTO.WrappingTypeDTO;
import cz.a7b36usi.sklad.Service.IOrderService;
import cz.a7b36usi.sklad.Service.IPartnerService;
import cz.a7b36usi.sklad.Service.IProductService;

/**
 * 
 * @author Lukas L.
 */
public class OrderServiceTest extends AbstractServiceTest {

	@Autowired
	IOrderService orderService;

	@Autowired
	IPartnerService partnerService;

	@Autowired
	IProductService productService;

	@Test
	public void testSaveOrderItemsAndGet() {
		partnerService.addPartner(true, false, "dsfsdfsd",
				"fdsfsdf", "NEJAKA", 333, 222);
		PartnerDTO p1 = partnerService.getAllPartners().get(0);
		Long cat = productService.saveCategory(new CategoryDTO(null,
				"NEJAKA KATEGORIE", null));
		Long product = productService.saveProduct(new ProductDTO(null,
				"PRODUKT1", "nakej posranej kod", 200, cat));
		Long sarze = productService.saveProductVersion(new ProductVersionDTO(null, 3434L, "name", product));
		Long druh = productService.saveWrappingType(new WrappingTypeDTO(null, "sfsdfsdfa", 4343.04, product));
		Long order1 = orderService.saveOrder(new OrderDTO(null, new Date(), "qwqewf3", null, p1));
		List<OrderItemDTO> list = new ArrayList<OrderItemDTO>();
		list.add(new OrderItemDTO(null, product, 500, druh, sarze, order1, ""));
		list.add(new OrderItemDTO(null, product, 700, druh, sarze, order1, ""));

		Long order = orderService.saveOrder(new OrderDTO(null, new Date(),
				"aaaa", null, p1));
		orderService.saveOrderItem(new OrderItemDTO(null, product, 500, druh,
				sarze, order, ""));
		orderService.saveOrderItem(new OrderItemDTO(null, product, 500, druh,
				sarze, order, ""));

		int size = orderService.getAllOrderItems(
				new OrderDTO(order, new Date(), null, null, null)).size();
		assertEquals(2, size);
	}

}
