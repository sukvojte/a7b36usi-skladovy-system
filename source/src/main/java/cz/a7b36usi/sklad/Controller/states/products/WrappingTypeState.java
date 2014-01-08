package cz.a7b36usi.sklad.Controller.states.products;

import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.Controller.states.documents.DocumentsState;
import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.DTO.WrappingTypeDTO;
import cz.a7b36usi.sklad.Service.IProductService;
import cz.a7b36usi.sklad.gui.IEditItemsGuiListener;
import cz.a7b36usi.sklad.gui.panels.ProductVersionPanel;
import cz.a7b36usi.sklad.gui.panels.WrappingTypePanel;
import cz.a7b36usi.sklad.gui.wrappingtype.ifaces.IWrappingTypeGUI;
import cz.a7b36usi.sklad.validators.CustomValidator;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class WrappingTypeState implements IWrappingTypeState,IEditItemsGuiListener{
	static final Logger logger = Logger.getLogger(WrappingTypeState.class);
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IWrappingTypeGUI wrappingTypeForm;

	private WrappingTypeDataModel model;
	private ProductDTO item;
	
	@PostConstruct
	public void registerModel() {
		wrappingTypeForm.addListeners(this);
		
	}

	
	public void openDialog(MainController controller,
			ProductsState state, ProductDTO product) {
		
		logger.debug("Open");
		
		
		
		item = product;
		
		model = new WrappingTypeDataModel(productService.getAllWrappingTypesByProduct(product.getId()));
		
		wrappingTypeForm.setTableModel(model, product);
		wrappingTypeForm.setVisible(true);
		
	}

	public void deactivated(MainController controller, DocumentsState state) {
		wrappingTypeForm.setVisible(false);
		wrappingTypeForm.editWrappingType(null);
	}



	public void save() {
		WrappingTypeDTO wt = wrappingTypeForm.getEditedWrappingType();
		productService.saveWrappingType(wt);
		updateModel();
	}



	public void click(int index) {
		WrappingTypeDTO wt = model.getRowByIndex(index);
		
		wrappingTypeForm.editWrappingType(wt);
	}



	public void delete() {
		WrappingTypeDTO wt = wrappingTypeForm.getEditedWrappingType();
		if(wt.getId() != null){
		    productService.removeWrappingType(wt.getId());
		    updateModel();
		}
	}
	
	private boolean updateModel() {

		if (item == null) {
			return false;
		}

		List<WrappingTypeDTO> items = productService.getAllWrappingTypesByProduct(item.getId());
		if (items == null) {
			return false;
		}

		if (model == null) {
			model = new WrappingTypeDataModel(items);
		} else {
			model.update(items);
		}

		return true;
	}

    public boolean validate() {
		WrappingTypePanel panel = wrappingTypeForm.getPanel();
	boolean test = true;
	if(panel.getMnozstviTF().getText() == null || panel.getJmenoTF().getText() == null){
	    return false;
	}
		if(panel.getMnozstviTF().getText().equals("0") || panel.getMnozstviTF().getText().equals("") || panel.getJmenoTF().getText().equals("")){
	    return false;
	}
	if(!CustomValidator.longValidate(panel.getMnozstviTF().getText())){
	    return false;
	}
	return true;
    }

}
