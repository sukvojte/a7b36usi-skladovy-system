package cz.a7b36usi.sklad.Controller.states.users;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.Controller.states.IControllerState;
import cz.a7b36usi.sklad.Controller.states.AddressBook.AddressBookState;
import cz.a7b36usi.sklad.Service.IUserService;

@Component
public class UsersState implements IControllerState{

	static final Logger logger = Logger.getLogger(AddressBookState.class);

	@Autowired
    private IUserService userService;
	
	private UsersDataModel model;
		
	@PostConstruct
    public void registerModel() {
		model = new UsersDataModel(userService.getAllUsers());
	}
	
	public void activated(MainController controller) {
		logger.debug("Activated event");

		controller.getForm().setTableModel(model);
		
	}

	public void editFormSave(MainController controller) {
		logger.debug("Save event");
	}

	public void selectedItem(MainController controller, int index) {
		
	}

}
