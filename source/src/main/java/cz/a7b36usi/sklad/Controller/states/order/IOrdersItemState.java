package cz.a7b36usi.sklad.Controller.states.order;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.DTO.OrderDTO;
import cz.a7b36usi.sklad.gui.orderitems.ifaces.IOrderItemsGuiListener;
/**
 * Is responsible for controlling states on orders
 * 
 * @author Aleksandr
 */
public interface IOrdersItemState extends IOrderItemsGuiListener {
        /**
        *  Sets orders window invisible
        * @param controller
        * @param state
        */
	void deactivated(MainController controller, OrdersState state);
        /**
        * Opens dialog with all products, versions and wrapping types
        * @param controller
        * @param state
        * @param item
        */
	void openDialog(MainController controller, OrdersState state, OrderDTO item);

}
