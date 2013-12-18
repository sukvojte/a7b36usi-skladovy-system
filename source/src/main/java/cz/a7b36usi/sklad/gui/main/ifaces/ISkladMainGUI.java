package cz.a7b36usi.sklad.gui.main.ifaces;

import java.util.List;

import cz.a7b36usi.sklad.Tabs;
import cz.a7b36usi.sklad.DTO.DocumentDTO;
import cz.a7b36usi.sklad.DTO.MovementDTO;
import cz.a7b36usi.sklad.DTO.OrderDTO;
import cz.a7b36usi.sklad.DTO.PartnerDTO;
import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.DTO.UserDTO;
import cz.a7b36usi.sklad.gui.main.listeners.IMainGuiListener;
import cz.a7b36usi.sklad.ifaces.RecieveListener;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;

/**
 *
 * @author Lukas L.
 */
public interface ISkladMainGUI extends RecieveListener<IMainGuiListener> {

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
    void setTableModel(BaseDataModel<?> model);

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
    void editOrder(OrderDTO order);

    /**
     * Edits movement
     *
     * @param order
     * @param list
     */
    void editMovement(MovementDTO movement);

    /**
     * Edits document
     *
     * @param order
     * @param list
     */
    void editDocument(DocumentDTO movement);
    
    /**
     * Edits product
     *
     * @param order
     * @param list
     */
    void editProduct(ProductDTO product);    

    /**
     * Set list to combolist
     *
     * @param list
     */
    void setPartnerList(List<PartnerDTO> list);
}
