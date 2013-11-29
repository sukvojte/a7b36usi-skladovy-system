package cz.a7b36usi.sklad.Controller.states;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Controller.MainController;

@Component
public class AddressBookState implements IControllerState{

	static final Logger logger = Logger.getLogger(AddressBookState.class);
	
	public void activated(MainController controller) {
		logger.debug("Save event");
	}
	
	public void save(MainController controller) {
		logger.debug("Save event");
	}

	

}
