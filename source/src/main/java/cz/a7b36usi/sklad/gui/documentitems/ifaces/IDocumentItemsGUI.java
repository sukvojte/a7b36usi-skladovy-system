package cz.a7b36usi.sklad.gui.documentitems.ifaces;

import java.util.List;

import cz.a7b36usi.sklad.DTO.MovementDTO;
import cz.a7b36usi.sklad.DTO.OrderItemDTO;
import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.gui.orderitems.ifaces.IOrderItemsGuiListener;
import cz.a7b36usi.sklad.ifaces.RecieveListener;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;

public interface IDocumentItemsGUI extends RecieveListener<IOrderItemsGuiListener>{

	void editMovementItem(MovementDTO orderItem);
	void setTableModel(BaseDataModel<?> model, List<ProductDTO> products);
	void setVisible(boolean visible);
	MovementDTO getMovementItem();
}
