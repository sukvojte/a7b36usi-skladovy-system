package cz.a7b36usi.sklad.gui.productversion.ifaces;

import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.DTO.ProductVersionDTO;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;

public interface IProductVersionGUI {
	void editProductVersion(ProductVersionDTO orderItem);

	void setTableModel(BaseDataModel<?> model, ProductDTO product);

	void setVisible(boolean visible);

	ProductVersionDTO getEditedProductVersion();
}
