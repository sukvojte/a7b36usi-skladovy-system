package cz.a7b36usi.sklad.Controller.states.movements;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.InputVerifier;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.Controller.states.IControllerState;
import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.Service.IDocumentService;

@Component
public class MovementsState implements IControllerState {

    static final Logger logger = Logger.getLogger(MovementsState.class);
    @Autowired
    private IDocumentService documentService;
    private MovementsDataModel model;

    @PostConstruct
    public void registerModel() {
	model = new MovementsDataModel(documentService.getAllMovements());
    }

    public void activated(MainController controller) {
	logger.debug("Activated event");

	model.update(documentService.getAllMovements());

	controller.getForm().setTableModel(model);
    }

    public void editFormSave(MainController controller) {
	logger.debug("Save event");
    }

    public void selectedItem(MainController controller, int index) {
    }

    public void deleteItem(MainController controller) {
    }

    public boolean validate(MainController controller) {
	return true;
    }

    public void itemDoubleClick(MainController controller, int index) {
    }

    public void print(int index) {
    }

    public void deactivated(MainController controller) {
    }

    public void filterByProduct(ProductDTO product) {
	model.update(documentService.getAllProductsMovements(product.getId()));
    }

    public void productVersionEdit(MainController ctrl, int index) {
    }

    public void wrappingTypeEdit(MainController ctrl, int index) {
    }
}
