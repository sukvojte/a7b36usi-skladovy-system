package cz.a7b36usi.sklad.gui.productversion;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.DTO.ProductVersionDTO;
import cz.a7b36usi.sklad.gui.EditWindowGUI;
import cz.a7b36usi.sklad.gui.panels.ProductVersionPanel;
import cz.a7b36usi.sklad.gui.panels.SubWindowPanel;
import cz.a7b36usi.sklad.gui.productversion.ifaces.IProductVersionGUI;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;

@Component
public class ProductVersionGUI extends EditWindowGUI implements IProductVersionGUI {

	private static final long serialVersionUID = 1739893632254201213L;

	static final Logger logger = Logger.getLogger(ProductVersionGUI.class);
	
	private ProductVersionDTO editedItem;
	
	private ProductVersionPanel panel;
	private ProductDTO product;
	

	@Override
	protected void afterInit(){
		
		panel = new ProductVersionPanel();
		
		getTopPanel().add(panel);
	}
	
	@Override
	protected void createNew(){
		editProductVersion(null);
	}
	
	
	public void editProductVersion(ProductVersionDTO productVersion) {
		
		if(productVersion != null){
			panel.getJmenoTF().setText(productVersion.getName());
			panel.getKodTF().setText(String.valueOf(productVersion.getCode()));
		}else{
			panel.getJmenoTF().setText("");
			panel.getKodTF().setText("0");
		}

		
		editedItem = productVersion;
	}

	public void setTableModel(BaseDataModel<?> model, ProductDTO product) {
		setBaseDataModel(model);
		this.product = product;
	}

	public ProductVersionDTO getEditedProductVersion() {
		if(editedItem == null){
			editedItem = new ProductVersionDTO();
		}
		
		editedItem.setCode(Long.parseLong(panel.getKodTF().getText()));
		editedItem.setName(panel.getJmenoTF().getText());
		
		editedItem.setProduct(this.product.getId());
		
		return editedItem;
	}

	public ProductVersionPanel getPanel(){
	    return panel;
	}
}
