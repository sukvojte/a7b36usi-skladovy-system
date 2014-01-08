package cz.a7b36usi.sklad.gui.wrappingtype.ifaces;

import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.DTO.WrappingTypeDTO;
import cz.a7b36usi.sklad.gui.IEditItemsGuiListener;
import cz.a7b36usi.sklad.gui.panels.WrappingTypePanel;
import cz.a7b36usi.sklad.ifaces.RecieveListener;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;

public interface IWrappingTypeGUI extends RecieveListener<IEditItemsGuiListener> {

    void editWrappingType(WrappingTypeDTO wrappingTypeDTO);

    void setTableModel(BaseDataModel<?> model, ProductDTO product);

    void setVisible(boolean visible);

    WrappingTypeDTO getEditedWrappingType();
    WrappingTypePanel getPanel();
}
