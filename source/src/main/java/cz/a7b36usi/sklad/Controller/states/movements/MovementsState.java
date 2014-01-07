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
import cz.a7b36usi.sklad.DTO.MovementDTO;
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

        MovementDTO movement = model.getRowByIndex(index);
		   //TODO: dodelat
        // controller.getForm().editCustomer(customer);
    }

    public void deleteItem(MainController controller) {//TODO: dodelat
        // MovementDTO movement =
        // controller.getForm().getData().getMovementData();
        //
        // model.update(zakaznikService.getAllPartners());
    }

    public boolean validate(MainController controller) {
        boolean correct = true;
        List<JTextField> list = controller.getForm().getTextFields()
                .getAddressBookTextFields();
        for (JTextField field : list) {
            InputVerifier iv = field.getInputVerifier();
            if (iv == null) {
                continue;
            }
            if (!iv.verify(field)) {
                correct = false;
            }
        }
        return correct;
    }

    public void itemDoubleClick(MainController controller, int index) {
        // TODO dodelat

    }

    public void print(int index) {
    }

    public void deactivated(MainController controller) {
        // TODO dodelat

    }

    public void filterByProduct(ProductDTO product) {
        model.update(documentService.getAllProductsMovements(product.getId()));
    }

	public void productVersionEdit(MainController ctrl, int index) {
		// TODO Auto-generated method stub
		
	}

	public void wrappingTypeEdit(MainController ctrl, int index) {
		// TODO Auto-generated method stub
		
	}

}
