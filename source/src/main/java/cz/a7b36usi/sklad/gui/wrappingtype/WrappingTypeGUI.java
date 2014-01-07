package cz.a7b36usi.sklad.gui.wrappingtype;


import cz.a7b36usi.sklad.gui.productversion.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.DTO.ProductVersionDTO;
import cz.a7b36usi.sklad.DTO.WrappingTypeDTO;
import cz.a7b36usi.sklad.gui.EditWindowGUI;
import cz.a7b36usi.sklad.gui.panels.ProductVersionPanel;
import cz.a7b36usi.sklad.gui.panels.SubWindowPanel;
import cz.a7b36usi.sklad.gui.panels.WrappingTypePanel;
import cz.a7b36usi.sklad.gui.productversion.ifaces.IProductVersionGUI;
import cz.a7b36usi.sklad.gui.wrappingtype.ifaces.IWrappingTypeGUI;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;

@Component
public class WrappingTypeGUI extends EditWindowGUI implements IWrappingTypeGUI {

	private static final long serialVersionUID = 173989345543534513L;

	static final Logger logger = Logger.getLogger(WrappingTypeGUI.class);
	
	private WrappingTypeDTO editedItem;
	
	private WrappingTypePanel panel;
	private ProductDTO product;
	

	@Override
	protected void afterInit(){
		
		panel = new WrappingTypePanel();
		
		getTopPanel().add(panel);
	}
	
	@Override
	protected void createNew(){
		editWrappingType(null);
	}
	
	
	public void editWrappingType(WrappingTypeDTO wrappingTypeDTO) {
		
		if(wrappingTypeDTO != null){
			panel.getJmenoTF().setText(wrappingTypeDTO.getName());
			panel.getMnozstviTF().setText(String.valueOf(wrappingTypeDTO.getQuantity()));
		}else{
			panel.getJmenoTF().setText("");
			panel.getMnozstviTF().setText("0");
		}

		
		editedItem = wrappingTypeDTO;
	}

	public void setTableModel(BaseDataModel<?> model, ProductDTO product) {
		setBaseDataModel(model);
		this.product = product;
	}

	public WrappingTypeDTO getEditedWrappingType() {
		if(editedItem == null){
			editedItem = new WrappingTypeDTO();
		}
		
		editedItem.setQuantity(Double.parseDouble(panel.getMnozstviTF().getText()));
		editedItem.setName(panel.getJmenoTF().getText());
		
		editedItem.setProduct(this.product.getId());
		
		return editedItem;
	}


}
