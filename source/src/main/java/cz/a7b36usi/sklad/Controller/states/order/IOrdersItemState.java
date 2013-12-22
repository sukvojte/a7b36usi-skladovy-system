package cz.a7b36usi.sklad.Controller.states.order;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.DTO.OrderDTO;
import cz.a7b36usi.sklad.gui.orderitems.ifaces.IOrderItemsGuiListener;

public interface IOrdersItemState extends IOrderItemsGuiListener {

	void deactivated(MainController controller, OrdersState state);

	void openDialog(MainController controller, OrdersState state, OrderDTO item);

}
