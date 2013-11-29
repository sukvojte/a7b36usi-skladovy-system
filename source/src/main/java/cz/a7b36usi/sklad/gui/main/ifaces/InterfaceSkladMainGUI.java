
package cz.a7b36usi.sklad.gui.main.ifaces;

import cz.a7b36usi.sklad.Tabs;
import cz.a7b36usi.sklad.DTO.UserDTO;
import cz.a7b36usi.sklad.gui.main.listeners.IMainGuiListener;

/**
 *
 * @author Lukas L.
 */
public interface InterfaceSkladMainGUI {
    void setVis(boolean t);
    void addListeners(IMainGuiListener listener);
    void removeListeners(IMainGuiListener listener);
    boolean switchTab(Tabs tab);
    
    //UserDTO getEditedUser();
    
    IGuiData getData();
}
