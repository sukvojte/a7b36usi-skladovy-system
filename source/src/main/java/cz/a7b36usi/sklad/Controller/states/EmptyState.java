package cz.a7b36usi.sklad.Controller.states;

import org.apache.log4j.Logger;

import cz.a7b36usi.sklad.Controller.MainController;

public class EmptyState implements IControllerState{
	static final Logger logger = Logger.getLogger(EmptyState.class);

	public void activated(MainController controller) {
		logger.debug("Save event");
	}
	
	public void save(MainController controller) {
		logger.warn("Save event");
	}
	
	
}
