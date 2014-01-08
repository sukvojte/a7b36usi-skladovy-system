package cz.a7b36usi.sklad.gui.orderitems.ifaces;

import java.util.List;

import cz.a7b36usi.sklad.DTO.OrderItemDTO;
import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.DTO.ProductVersionDTO;
import cz.a7b36usi.sklad.DTO.WrappingTypeDTO;
import cz.a7b36usi.sklad.gui.IEditItemsGuiListener;
import cz.a7b36usi.sklad.gui.panels.SubWindowPanel;
import cz.a7b36usi.sklad.ifaces.RecieveListener;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;

public interface IOrderItemsGUI extends RecieveListener<IEditItemsGuiListener> {

	void editOrderItem(OrderItemDTO orderItem);

	void setTableModel(BaseDataModel<?> model, List<ProductDTO> products, List<ProductVersionDTO> productVersions, List<WrappingTypeDTO> wrappings);

	void setVisible(boolean visible);

	OrderItemDTO getEditedOrderItem();
	
	SubWindowPanel getPanel();
}
