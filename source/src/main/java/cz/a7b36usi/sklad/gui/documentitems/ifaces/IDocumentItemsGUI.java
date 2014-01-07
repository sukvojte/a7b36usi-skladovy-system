package cz.a7b36usi.sklad.gui.documentitems.ifaces;

import java.util.List;

import cz.a7b36usi.sklad.DTO.MovementDTO;
import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.DTO.ProductVersionDTO;
import cz.a7b36usi.sklad.DTO.WrappingTypeDTO;
import cz.a7b36usi.sklad.gui.IEditItemsGuiListener;
import cz.a7b36usi.sklad.ifaces.RecieveListener;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;

public interface IDocumentItemsGUI extends
		RecieveListener<IEditItemsGuiListener> {

	void editMovementItem(MovementDTO orderItem);

	void setTableModel(BaseDataModel<?> model, List<ProductDTO> products, List<ProductVersionDTO> productVersions, List<WrappingTypeDTO> wrappings);

	void setVisible(boolean visible);

	MovementDTO getEditedMovementItem();
}
