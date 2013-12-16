package cz.a7b36usi.sklad.ifaces;

import cz.a7b36usi.sklad.gui.main.listeners.IMainGuiListener;

public interface RecieveListener {

    /**
     * Adds IMainGuiListener
     *
     * @param listener
     */
    void addListeners(IMainGuiListener listener);

    /**
     * Removes IMainGuiListener
     *
     * @param listener
     */
    void removeListeners(IMainGuiListener listener);
}
