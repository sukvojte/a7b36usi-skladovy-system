package cz.a7b36usi.sklad.ifaces;

import cz.a7b36usi.sklad.gui.main.listeners.IMainGuiListener;

public interface RecieveListener {
	void addListeners(IMainGuiListener listener);
    void removeListeners(IMainGuiListener listener);
}
