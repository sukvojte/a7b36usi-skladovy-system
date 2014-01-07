package cz.a7b36usi.sklad.gui.productversion.ifaces;

import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.DTO.ProductVersionDTO;
import cz.a7b36usi.sklad.DTO.WrappingTypeDTO;
import cz.a7b36usi.sklad.gui.IEditItemsGuiListener;
import cz.a7b36usi.sklad.ifaces.RecieveListener;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;

public interface IProductVersionGUI extends RecieveListener<IEditItemsGuiListener> {
	void editProductVersion(ProductVersionDTO productVersion);

	void setTableModel(BaseDataModel<?> model, ProductDTO product);

	void setVisible(boolean visible);

	ProductVersionDTO getEditedProductVersion();
}
