package cz.a7b36usi.sklad.Controller.states;

import cz.a7b36usi.sklad.Controller.MainController;

public interface IControllerState {
	void activated(MainController controller);
	void editFormSave(MainController controller);
	void selectedItem(MainController controller, int index);
	
}
