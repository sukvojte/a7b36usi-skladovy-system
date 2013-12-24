package cz.a7b36usi.sklad.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.DTO.OrderDTO;
import cz.a7b36usi.sklad.DTO.OrderItemDTO;
import org.apache.log4j.Logger;

/**
 * 
 * @author Lukas L.
 */
@Component
public class PrintService implements IPrintService {
	@Autowired
	IOrderService orderService;
	static final Logger logger = Logger.getLogger(PrintService.class);
	
	public boolean printOrder(Long orderId) {
		try {
			JasperReport jr = null;
			JasperPrint jp = null;
			Map<String, Object> params = new HashMap<String, Object>();

			List<OrderItemDTO> orderItems = orderService
					.getAllOrderItems(new OrderDTO(orderId, null, null, null,
							null));
			jr = (JasperReport) JRLoader.loadObject(new File("order1.jasper"));
			jp = JasperFillManager.fillReport(jr, params,
					new JRBeanCollectionDataSource(orderItems));
			JasperPrintManager.printReport(jp, true);
		} catch (JRException ex) {
			ex.printStackTrace();
			logger.error("Error while printing");
			return false;
		}
		return true;
	}

}
