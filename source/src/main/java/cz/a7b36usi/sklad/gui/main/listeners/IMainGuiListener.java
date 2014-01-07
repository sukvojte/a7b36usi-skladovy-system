package cz.a7b36usi.sklad.gui.main.listeners;

import cz.a7b36usi.sklad.Tabs;

/**
 * Listener on events at the main window
 * @author Aleksandr
 */
public interface IMainGuiListener {

	/**
     * Is called when the user switches tabs
     * @param activetTab
     *          Tab the user clicks
     */
    void tabChanged(Tabs activetTab);

	void editFormSave();

	/**
     *  
     * @param index
     *          Index of the selected table
     */
    void tableSelectedIndex(int index);

	/**
     *
     * @param index
     *          Index of the table on which was performed double click action
     */
    void tableDoubleClickOnIndex(int index);

	/**
     * Removes the main controller
     */
    void deleteItem();

	/**
     *  Validates user's input values
     * @return
     */
    boolean validate();

	/**
     *  Prints data
     * @param index
     */
    void print(int index);

    void productVersionEdit(int index);

    void wrappingTypeEdit(int index);
}
