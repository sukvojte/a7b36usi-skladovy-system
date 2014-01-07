package cz.a7b36usi.sklad.Controller.states.products;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.Controller.states.documents.DocumentsState;
import cz.a7b36usi.sklad.DTO.ProductDTO;

public interface IWrappingTypeState {

	void openDialog(MainController controller, ProductsState productsState,
			ProductDTO rowByIndex);

	/**
     *  Sets items window invisible
     * @param controller
     * @param state
     */
    void deactivated(MainController controller, DocumentsState state);
	
}
