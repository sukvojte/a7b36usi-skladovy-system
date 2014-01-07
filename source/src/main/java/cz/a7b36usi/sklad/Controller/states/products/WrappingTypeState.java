package cz.a7b36usi.sklad.Controller.states.products;

import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.Controller.states.documents.DocumentsState;
import cz.a7b36usi.sklad.DTO.ProductDTO;

@Component
public class WrappingTypeState implements IWrappingTypeState{

	public void openDialog(MainController controller,
			ProductsState productsState, ProductDTO rowByIndex) {
		// TODO Auto-generated method stub
		
	}

	public void deactivated(MainController controller, DocumentsState state) {
		// TODO Auto-generated method stub
		
	}

}
