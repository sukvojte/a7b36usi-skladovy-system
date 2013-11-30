package cz.a7b36usi.sklad.gui.main.listeners;

import cz.a7b36usi.sklad.Tabs;

public interface IMainGuiListener {
	
	void tabChanged(Tabs activetTab);
	void editFormSave();
	void tableSelectedIndex(int index);
        void deleteFromDatabase();
	
}
