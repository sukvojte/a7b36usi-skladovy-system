package cz.a7b36usi.sklad.Controller.states.products;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.Controller.states.documents.DocumentsState;
import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.DTO.ProductVersionDTO;
import cz.a7b36usi.sklad.Service.IProductService;
import cz.a7b36usi.sklad.gui.IEditItemsGuiListener;
import cz.a7b36usi.sklad.gui.productversion.ifaces.IProductVersionGUI;

@Component
public class ProductVersionState implements IProductVersionState,IEditItemsGuiListener  {

	static final Logger logger = Logger.getLogger(ProductVersionState.class);
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IProductVersionGUI productVersionForm;

	private ProductVersionDataModel model;
	private ProductDTO item;
	
	@PostConstruct
	public void registerModel() {
		productVersionForm.addListeners(this);
		
	}

	
	public void openDialog(MainController controller,
			ProductsState state, ProductDTO product) {
		
		logger.debug("Open");
		
		
		
		item = product;
		
		model = new ProductVersionDataModel(productService.getAllProductVersionsByProduct(product.getId()));
		
		productVersionForm.setTableModel(model, product);
		productVersionForm.setVisible(true);
		
	}

	public void deactivated(MainController controller, DocumentsState state) {
		productVersionForm.setVisible(false);
		productVersionForm.editProductVersion(null);
	}



	public void save() {
		ProductVersionDTO productVersion = productVersionForm.getEditedProductVersion();
		productService.saveProductVersion(productVersion);
		updateModel();
	}



	public void click(int index) {
		ProductVersionDTO productVersion = model.getRowByIndex(index);
		
		productVersionForm.editProductVersion(productVersion);
	}



	public void delete() {
		ProductVersionDTO productVersion = productVersionForm.getEditedProductVersion();
		if(productVersion.getId() != null){
		    productService.removeProductVersion(productVersion.getId());
		    updateModel();
		}
	}
	
	private boolean updateModel() {

		if (item == null) {
			return false;
		}

		List<ProductVersionDTO> items = productService.getAllProductVersionsByProduct(item.getId());
		if (items == null) {
			return false;
		}

		if (model == null) {
			model = new ProductVersionDataModel(items);
		} else {
			model.update(items);
		}

		return true;
	}

}
