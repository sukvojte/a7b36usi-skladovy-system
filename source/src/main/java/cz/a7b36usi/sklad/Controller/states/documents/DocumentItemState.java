package cz.a7b36usi.sklad.Controller.states.documents;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.DTO.DocumentDTO;
import cz.a7b36usi.sklad.DTO.MovementDTO;
import cz.a7b36usi.sklad.DTO.OrderDTO;
import cz.a7b36usi.sklad.DTO.OrderItemDTO;
import cz.a7b36usi.sklad.Service.IDocumentService;
import cz.a7b36usi.sklad.Service.IOrderService;
import cz.a7b36usi.sklad.Service.IProductService;
import cz.a7b36usi.sklad.gui.documentitems.DocumentItemsDataModel;
import cz.a7b36usi.sklad.gui.documentitems.ifaces.IDocumentItemsGUI;
import cz.a7b36usi.sklad.gui.orderitems.OrderItemsDataModel;
import cz.a7b36usi.sklad.gui.orderitems.ifaces.IOrderItemsGUI;


@Component
public class DocumentItemState implements IDocumentItemState{

	static final Logger logger = Logger.getLogger(DocumentItemState.class);
	
	@Autowired
	private IDocumentItemsGUI orderEditForm; 
	
	@Autowired
	private IProductService productService;
	
	@Autowired
    private IDocumentService documentService;
	
	private DocumentItemsDataModel model;
	private DocumentDTO item;
	
	@PostConstruct
    public void registerModel() {
		orderEditForm.addListeners(this);
	}
	
	public void save() {
		MovementDTO movement = orderEditForm.getEditedMovementItem();
		
		//movement.setDocument(item.getId());
		
		logger.debug("Save item " + movement.getId());
		documentService.saveMovement(movement);

		updateModel();	
	}

	public void click(int index) {
		logger.debug("Edit item " + index);
		MovementDTO orderItem = model.getRowByIndex(index);
		orderEditForm.editMovementItem(orderItem);
	}
	
	public void deactivated(MainController controller, DocumentsState state) {
		orderEditForm.setVisible(false);
	}
	
	public void openDialog(MainController controller, DocumentsState state, DocumentDTO item){
		
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
		/*
		List<OrderItemDTO> items = documentService.getMo(item);
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
		*/
		return true;
	}

	public void delete() {
		/*
		OrderItemDTO orderItem = orderEditForm.getEditedOrderItem();
		logger.debug("Delete item " + orderItem.getId());
		orderService.removeOrderItem(orderItem);
		updateModel();
		*/
	}

}
