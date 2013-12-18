package cz.a7b36usi.sklad.Controller.states.order;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.InputVerifier;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.Controller.states.IControllerState;
import cz.a7b36usi.sklad.Controller.states.AddressBook.AddressBookDataModel;
import cz.a7b36usi.sklad.Controller.states.AddressBook.AddressBookState;
import cz.a7b36usi.sklad.DTO.OrderDTO;
import cz.a7b36usi.sklad.DTO.OrderItemDTO;
import cz.a7b36usi.sklad.DTO.PartnerDTO;
import cz.a7b36usi.sklad.Service.IOrderService;
import cz.a7b36usi.sklad.Service.IPartnerService;
import cz.a7b36usi.sklad.Service.IPrintService;
import cz.a7b36usi.sklad.Service.IProductService;
import cz.a7b36usi.sklad.gui.main.SkladMainGUI;
import cz.a7b36usi.sklad.gui.main.ifaces.ISkladMainGUI;
import cz.a7b36usi.sklad.gui.wizard.IOrderItemsGUI;
import cz.a7b36usi.sklad.gui.wizard.OrderItemsDataModel;

import javax.swing.JOptionPane;

@Component
public class OrdersState implements IControllerState{

	static final Logger logger = Logger.getLogger(OrdersState.class);

	@Autowired
    private IOrderService orderService;
	
    @Autowired
    IPrintService printService;	
	
	@Autowired
	private IPartnerService partnerService;
	
	@Autowired
	private IProductService productService;
	
	private OrdersDataModel model;
	
	@Autowired
	private IOrderItemsGUI orderEditForm; 
	
	@PostConstruct
    public void registerModel() {
		model = new OrdersDataModel(orderService.getAllOrders());
	}
	
	public void activated(MainController controller) {
		logger.debug("Activated event");
		
		controller.getForm().setTableModel(model);
		controller.getForm().setPartnerList(partnerService.getAllPartners());
	}
	

	public void deactivated(MainController controller) {
		//editForm.setVisible(false);
		
	}

	public void editFormSave(MainController controller) {
		logger.debug("Save event");
		
		OrderDTO order = controller.getForm().getData().getOrderData();
		
		if(order != null){
			logger.debug("Save order " + order.getId());
			orderService.saveOrder(order);
			model.update(orderService.getAllOrders());
		}else{
			logger.error("Can't save null customer");
		}
	}

	public void selectedItem(MainController controller, int index) {
		OrderDTO order = model.getRowByIndex(index); 
		
		controller.getForm().editOrder(order);	
	}

    public void deleteItem(MainController controller) {
    	OrderDTO order = controller.getForm().getData().getOrderData();
    	orderService.removeOrder(order);
        model.update(orderService.getAllOrders());
    }

    public boolean validate(MainController controller) {
    	boolean correct = true;
        List<JTextField> list = controller.getForm().getTextFields().getOrderTextFields();
        for (JTextField field : list) {
            InputVerifier iv = field.getInputVerifier();
               if(iv == null)continue;
               if(!iv.verify(field)){
                   correct = false;
               }
        }
        return correct;
    }

	public void itemDoubleClick(MainController controller, int index) {
		logger.debug("item double click");
		
		List<OrderItemDTO> items = model.getRowByIndex(index).getItems();
		if(items == null){
			logger.error("Items is null!");
			return;
		}
		orderEditForm.setTableModel(new OrderItemsDataModel(items),productService.getAllProducts());
		orderEditForm.setVisible(true);		
	}

    public void print(int index) {
		if(!printService.printOrder(model.getRowByIndex(index).getId())){
		    JOptionPane.showMessageDialog(null, "Problem s tiskem.", "Tisk se nezdaril", JOptionPane.ERROR_MESSAGE);
		}
    }


}
