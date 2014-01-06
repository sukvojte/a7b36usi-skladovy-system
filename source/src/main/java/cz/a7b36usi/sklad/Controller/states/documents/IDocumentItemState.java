package cz.a7b36usi.sklad.Controller.states.documents;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.DTO.DocumentDTO;
import cz.a7b36usi.sklad.gui.orderitems.ifaces.IOrderItemsGuiListener;

/**
 * Is responsible for controlling states on items
 * 
 * @author Aleksandr
 */
public interface IDocumentItemState extends IOrderItemsGuiListener {

	/**
     *  Sets items window invisible
     * @param controller
     * @param state
     */
    void deactivated(MainController controller, DocumentsState state);

	/**
     * Opens dialog with all products, versions and wrapping types
     * @param controller
     * @param state
     * @param item
     */
    void openDialog(MainController controller, DocumentsState state,
			DocumentDTO item);

}
