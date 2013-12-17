package cz.a7b36usi.sklad.gui.main.ifaces;

import cz.a7b36usi.sklad.DTO.OrderDTO;
import cz.a7b36usi.sklad.DTO.UserDTO;
import cz.a7b36usi.sklad.Tabs;
import cz.a7b36usi.sklad.DTO.PartnerDTO;
import cz.a7b36usi.sklad.ifaces.RecieveListener;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;
import java.awt.Component;
import java.util.List;

/**
 *
 * @author Lukas L.
 */
public interface ISkladMainGUI extends RecieveListener {

    /**
     * Set SkladMainGUI visibility.
     *
     * @param state
     */
    void setVisible(boolean state);

    /**
     * Swtiches tab
     *
     * @param tab
     * @return
     */
    boolean switchTab(Tabs tab);

    /**
     * Gets callback to data from forms
     *
     * @return
     */
    IGuiData getData();

    /**
     * Returns list of textfields for validations
     *
     * @return
     */
    IGuiTextFields getTextFields();

    /**
     * Sets table model in view
     * 
     * @param model
     */
    void setTableModel(BaseDataModel model);

    /**
     * Edits customer
     * 
     * @param customer 
     */
    void editCustomer(PartnerDTO customer);

    /**
     * Edits user
     * 
     * @param user 
     */
    void editUser(UserDTO user);
    
    /**
     * Edits order
     * 
     * @param order
     * @param list 
     */
    void editOrder(OrderDTO order, List<OrderDTO> list);
}
