package cz.a7b36usi.sklad.Controller.states.AddressBook;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.Controller.states.IControllerState;
import cz.a7b36usi.sklad.DTO.ZakaznikDTO;
import cz.a7b36usi.sklad.Service.IZakaznikService;
import java.util.List;
import javax.swing.InputVerifier;
import javax.swing.JPanel;
import javax.swing.JTextField;

@Component
public class AddressBookState implements IControllerState{

	static final Logger logger = Logger.getLogger(AddressBookState.class);
	
	
	@Autowired
    private IZakaznikService zakaznikService;
	
	private AddressBookDataModel model;
	
	@PostConstruct
    public void registerModel() {
		model = new AddressBookDataModel(zakaznikService.getAllZakaznik());
	}
	
	public void activated(MainController controller) {
		logger.debug("Activated event");
		
		controller.getForm().setTableModel(model);
	}
	
	public void editFormSave(MainController controller) {
		logger.debug("Save event");
		
		ZakaznikDTO customer = controller.getForm().getData().getZakaznikData();
		
		
		
		if(customer != null){
			logger.debug("Save customer " + customer.getId());
			if(zakaznikService.saveZakaznik(customer)){
				model.update(zakaznikService.getAllZakaznik());
			}else{
				logger.error("Customer " + customer.getId() + " was not saved");
			}
		}else{
			logger.error("Can't save null customer");
		}
		
	}

	public void selectedItem(MainController controller, int index) {
		
		ZakaznikDTO customer = model.getRowByIndex(index); 
		
		controller.getForm().editCustomer(customer);		
	}

    public void deleteItem(MainController controller) {
        ZakaznikDTO customer = controller.getForm().getData().getZakaznikData();
        zakaznikService.removeZakaznik(customer);
        model.update(zakaznikService.getAllZakaznik());
    }

    public boolean validate(MainController controller) {
        boolean correct = true;
        List<JTextField> list = controller.getForm().getTextFields().getAdresBookTextFields();
        for (JTextField field : list) {
            InputVerifier iv = field.getInputVerifier();
               if(iv == null)continue;
               if(!iv.verify(field)){
                   correct = false;
               }
        }
        return correct;
    }
		

}
