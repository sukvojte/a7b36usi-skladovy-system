package cz.a7b36usi.sklad.gui.main.ifaces;

import cz.a7b36usi.sklad.DTO.DocumentDTO;
import cz.a7b36usi.sklad.DTO.MovementDTO;
import cz.a7b36usi.sklad.DTO.OrderDTO;
import cz.a7b36usi.sklad.DTO.UserDTO;
import cz.a7b36usi.sklad.DTO.PartnerDTO;
import cz.a7b36usi.sklad.DTO.ProductDTO;

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
    
    /**
     * Gets documents data from form
     * @return 
     */
    DocumentDTO getDocumentData();
    
    /**
     * Gets product data from form
     * @return 
     */
    ProductDTO getProductData();    
    
    
}
