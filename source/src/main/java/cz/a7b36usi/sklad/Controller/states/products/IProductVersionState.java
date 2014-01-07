package cz.a7b36usi.sklad.Controller.states.products;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.Controller.states.documents.DocumentsState;
import cz.a7b36usi.sklad.DTO.ProductDTO;

public interface IProductVersionState {

	void openDialog(MainController controller, ProductsState state,
			ProductDTO product);
	
	/**
     *  Sets items window invisible
     * @param controller
     * @param state
     */
    void deactivated(MainController controller, DocumentsState state);
}
