
package cz.a7b36usi.sklad.gui.main.ifaces;


import cz.a7b36usi.sklad.DTO.UserDTO;
import cz.a7b36usi.sklad.Tabs;
import cz.a7b36usi.sklad.DTO.ZakaznikDTO;
import cz.a7b36usi.sklad.ifaces.RecieveListener;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;
import java.awt.Component;

/**
 *
 * @author Lukas L.
 */
public interface ISkladMainGUI extends RecieveListener{
    void setVisible(boolean state); // Staci pouzit tohle, metodu implementuje uz JFrame
        
    boolean switchTab(Tabs tab); // prehodi na zadanou zalozku
    
    IGuiData getData(); // ziska callback na data z formularu
    
    IGuiTextFields getTextFields(); // ziska list text fieldu, ktere jsou potrebne pro validaci
    
    void setTableModel(BaseDataModel model);

    void editCustomer(ZakaznikDTO customer);
    
    void editUser (UserDTO user);
    
}
