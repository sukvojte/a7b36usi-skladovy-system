package cz.a7b36usi.sklad.Controller.states.movements;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.Controller.states.IControllerState;
import cz.a7b36usi.sklad.DTO.MovementDTO;
import cz.a7b36usi.sklad.DTO.PartnerDTO;
import cz.a7b36usi.sklad.Service.IDocumentService;
import cz.a7b36usi.sklad.Service.IPartnerService;
import cz.a7b36usi.sklad.Service.IProductService;
import java.util.List;
import javax.swing.InputVerifier;
import javax.swing.JPanel;
import javax.swing.JTextField;

@Component
public class MovementsState implements IControllerState{

	static final Logger logger = Logger.getLogger(MovementsState.class);
	
	
	@Autowired
    private IDocumentService documentService;//TODO: get all movements je kde ?
	
	private MovementsDataModel model;
	
	@PostConstruct
    public void registerModel() {
		model = new MovementsDataModel(documentService.getAllMovements());
	}
	
	public void activated(MainController controller) {
		logger.debug("Activated event");
		
		controller.getForm().setTableModel(model);
	}
	
	public void editFormSave(MainController controller) {
		logger.debug("Save event");
		   //TODO: tady asi nic nebude
	}

	public void selectedItem(MainController controller, int index) {
		
		MovementDTO movement = model.getRowByIndex(index); 
		
		//controller.getForm().editCustomer(customer);		
	}

    public void deleteItem(MainController controller) {
//        MovementDTO movement = controller.getForm().getData().getMovementData();
//        
//        model.update(zakaznikService.getAllPartners());
    }

    public boolean validate(MainController controller) {
        boolean correct = true;
        List<JTextField> list = controller.getForm().getTextFields().getAddressBookTextFields();
        for (JTextField field : list) {
            InputVerifier iv = field.getInputVerifier();
               if(iv == null)continue;
               if(!iv.verify(field)){
                   correct = false;
               }
        }
        return correct;
    }

	public void itemDoubleClick(MainController controller, int index) {
		// TODO Auto-generated method stub
		
	}
		

}
