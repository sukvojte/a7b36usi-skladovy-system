package cz.a7b36usi.sklad.gui.orderitems;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.DTO.OrderItemDTO;
import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.DTO.ProductVersionDTO;
import cz.a7b36usi.sklad.DTO.WrappingTypeDTO;
import cz.a7b36usi.sklad.gui.EditWindowGUI;
import cz.a7b36usi.sklad.gui.ListComboBoxModel;
import cz.a7b36usi.sklad.gui.orderitems.ifaces.IOrderItemsGUI;
import cz.a7b36usi.sklad.gui.panels.SubWindowPanel;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;
import javax.swing.ComboBoxModel;
import javax.swing.SwingUtilities;

@Component
public class OrderItemsGUI extends EditWindowGUI implements IOrderItemsGUI {

    private static final long serialVersionUID = -6634089119262748440L;
    static final Logger logger = Logger.getLogger(OrderItemsGUI.class);
    private OrderItemDTO editedItem;
    private SubWindowPanel panel;

    @Override
    protected void afterInit() {

	panel = new SubWindowPanel();

	getTopPanel().add(panel);
    }

    @Override
    protected void createNew() {
	editOrderItem(null);
    }

    public void editOrderItem(OrderItemDTO orderItem) {

	if (orderItem != null) {
	    panel.getCbProdukt().getModel().setSelectedItem(orderItem.getProduct());
	    
	    ComboBoxModel<WrappingTypeDTO> wtm = panel.getDruhBaleniCB().getModel();
	    for (int i = 0; i < wtm.getSize(); i++) {
		if(orderItem.getWrappingType().equals(wtm.getElementAt(i).getId())){
		    panel.getDruhBaleniCB().setSelectedIndex(i);
		    break;
		}
	    }
	    ComboBoxModel<ProductVersionDTO> pvm = panel.getSarzeCB().getModel();
	    for (int i = 0; i < pvm.getSize(); i++) {
		if(orderItem.getProductVersion().equals(pvm.getElementAt(i).getId())){
		    panel.getSarzeCB().setSelectedIndex(i);
		    break;
		}
	    }
	    panel.getTbCount().setText(String.valueOf(orderItem.getQuantity()));
	} else {
	    panel.getCbProdukt().setSelectedItem(null);
	    panel.getDruhBaleniCB().setSelectedItem(null);
	    panel.getSarzeCB().setSelectedItem(null);
	    panel.getTbCount().setText("0");
	}
	panel.refreshComponents();
	editedItem = orderItem;
    }

    public void setTableModel(BaseDataModel<?> model,
	    List<ProductDTO> products,
	    List<ProductVersionDTO> productVersions,
	    List<WrappingTypeDTO> wrappings) {

	setBaseDataModel(model);

	panel.getCbProdukt().setModel(new ListComboBoxModel<ProductDTO>(products, ProductDTO.class));
	panel.getDruhBaleniCB().setModel(new ListComboBoxModel<WrappingTypeDTO>(wrappings, WrappingTypeDTO.class));
	panel.getSarzeCB().setModel(new ListComboBoxModel<ProductVersionDTO>(productVersions, ProductVersionDTO.class));

    }

    public OrderItemDTO getEditedOrderItem() {
	if (editedItem == null) {
	    editedItem = new OrderItemDTO();
	}

	editedItem.setProduct(((ListComboBoxModel<ProductDTO>) panel.getCbProdukt().getModel()).getActiveId());
	editedItem.setWrappingType(((ListComboBoxModel<WrappingTypeDTO>) panel.getDruhBaleniCB().getModel()).getActiveId());
	editedItem.setProductVersion(((ListComboBoxModel<ProductVersionDTO>) panel.getSarzeCB().getModel()).getActiveId());
	editedItem.setQuantity(Integer.parseInt(panel.getTbCount().getText()));

	return editedItem;
    }

    public SubWindowPanel getPanel() {
	return panel;
    }
}
