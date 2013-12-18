package cz.a7b36usi.sklad.gui.wizard;

import java.util.List;

import cz.a7b36usi.sklad.DTO.OrderItemDTO;
import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.ifaces.RecieveListener;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;

public interface IOrderItemsGUI extends RecieveListener<IOrderItemsGuiListener>{

	void editOrderItem(OrderItemDTO orderItem);
	void setTableModel(BaseDataModel<?> model, List<ProductDTO> products);
	void setVisible(boolean visible);
}
