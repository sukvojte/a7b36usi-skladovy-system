package cz.a7b36usi.sklad.Controller.states.documents;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.DTO.DocumentDTO;
import cz.a7b36usi.sklad.DTO.OrderDTO;
import cz.a7b36usi.sklad.gui.orderitems.ifaces.IOrderItemsGuiListener;

public interface IDocumentItemState extends IOrderItemsGuiListener{

	void deactivated(MainController controller, DocumentsState state);
	void openDialog(MainController controller, DocumentsState state, DocumentDTO item);
	
}
