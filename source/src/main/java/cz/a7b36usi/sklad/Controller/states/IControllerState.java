package cz.a7b36usi.sklad.Controller.states;

import cz.a7b36usi.sklad.Controller.MainController;

public interface IControllerState {
	void activated(MainController controller);
	void save(MainController controller);
	
}
