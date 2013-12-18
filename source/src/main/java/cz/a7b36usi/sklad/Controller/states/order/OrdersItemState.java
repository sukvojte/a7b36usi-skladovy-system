package cz.a7b36usi.sklad.Controller.states.order;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.DTO.OrderDTO;
import cz.a7b36usi.sklad.DTO.OrderItemDTO;
import cz.a7b36usi.sklad.Service.IOrderService;
import cz.a7b36usi.sklad.Service.IProductService;
import cz.a7b36usi.sklad.gui.orderitems.OrderItemsDataModel;
import cz.a7b36usi.sklad.gui.orderitems.ifaces.IOrderItemsGUI;


@Component
public class OrdersItemState implements IOrdersItemState{

	static final Logger logger = Logger.getLogger(OrdersItemState.class);
	
	@Autowired
	private IOrderItemsGUI orderEditForm; 
	
	@Autowired
	private IProductService productService;
	
	@Autowired
    private IOrderService orderService;
	
	private OrderItemsDataModel model;
	private OrderDTO item;
	
	@PostConstruct
    public void registerModel() {
		orderEditForm.addListeners(this);
	}
	
	public void save() {
		OrderItemDTO orderItem = orderEditForm.getEditedOrderItem();
		
		orderItem.setOrder(item.getId());
		
		logger.debug("Save item " + orderItem.getId());
		orderService.saveOrderItem(orderItem);

		updateModel();	
	}

	public void click(int index) {
		logger.debug("Edit item " + index);
		OrderItemDTO orderItem = model.getRowByIndex(index);
		orderEditForm.editOrderItem(orderItem);
	}
	
	public void deactivated(MainController controller, OrdersState state) {
		orderEditForm.setVisible(false);
	}
	
	public void openDialog(MainController controller, OrdersState state, OrderDTO item){
		
		this.item = item; 
		
		if(updateModel()){		
			orderEditForm.setTableModel(model, productService.getAllProducts());
			orderEditForm.setVisible(true);
		}
	}
	
	private boolean updateModel(){
		
		if(item == null){
			logger.error("Item is null!");
			return false;
		}
		
		List<OrderItemDTO> items = orderService.getOrderItems(item);
		if(items == null){
			logger.error("Items is null!");
			return false;
		}
		
		if(model == null){
			logger.debug("Create new model");
			model = new OrderItemsDataModel(items);
		}else{
			logger.debug("Updating model");
			model.update(items);
		}
		
		return true;
	}

	public void delete() {
		OrderItemDTO orderItem = orderEditForm.getEditedOrderItem();
		logger.debug("Delete item " + orderItem.getId());
		orderService.removeOrderItem(orderItem);
		updateModel();
	}


}
