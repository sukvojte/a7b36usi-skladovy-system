package cz.a7b36usi.sklad.gui.main.ifaces;

import cz.a7b36usi.sklad.DTO.OrderDTO;
import cz.a7b36usi.sklad.DTO.UserDTO;
import cz.a7b36usi.sklad.DTO.PartnerDTO;

public interface IGuiData {

    /**
     * Gets user data from form
     * 
     * @return created UserDTO from form values
     */
    UserDTO getUserData();

    /**
     * Gets partner data from form
     * 
     * @return created UserDTO from form values
     */    
    PartnerDTO getPartnerData();
    
    /**
     * Gets order data from form
     * @return 
     */
    OrderDTO getOrderData();
}
