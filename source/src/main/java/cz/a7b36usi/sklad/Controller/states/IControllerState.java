package cz.a7b36usi.sklad.Controller.states;

import cz.a7b36usi.sklad.Controller.MainController;

public interface IControllerState {
	/**
	 * This method is called, when the tab is activated. 
	 * And it sets the correct table model for the form, which is taken from controller.
	 * @param controller 
	 */
	void activated(MainController controller);
	
	/**
	 * This method is called, when the save button is clicked.
	 * And it saves data which is taken from controller.
	 * @param controller 
	 */
	void editFormSave(MainController controller);
	
	/**
	 * This method is called, when the item on index is selected.
	 * And it sets data to form, which is taken from controller.
	 * @param controller 
	 * @param index 
	 */
	void selectedItem(MainController controller, int index);
	
	/**
	 * This method is called, when the delete button is clicked.
	 * And it deletes data from database, which are taken from controller.
	 * @param controller 
	 */	
	void deleteItem(MainController controller);
	
	/**
	 * This method is called, when save button is clicked. 
	 * It validates user's input values.
	 * @param controller
	 * @return true when data is correct, false otherwise
	 */
        boolean validate(MainController controller);

    	/**
    	 * This method is called, when the item on index is doubleclicked.
    	 * @param index
    	 */
        void itemDoubleClick(MainController controller, int index);
	
	/**
	 * Prints data
	 * 
	 * @param index 
	 */
	void print(int index);
}
