package cz.a7b36usi.sklad.Controller.states.products;

import cz.a7b36usi.sklad.Controller.states.movements.*;
import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.Controller.states.IControllerState;
import cz.a7b36usi.sklad.DTO.MovementDTO;
import cz.a7b36usi.sklad.DTO.PartnerDTO;
import cz.a7b36usi.sklad.DTO.ProductDTO;
import cz.a7b36usi.sklad.Service.IPartnerService;
import cz.a7b36usi.sklad.Service.IProductService;
import java.util.List;
import javax.swing.InputVerifier;
import javax.swing.JPanel;
import javax.swing.JTextField;

@Component
public class ProductsState implements IControllerState{

	static final Logger logger = Logger.getLogger(ProductsState.class);
	
	
	@Autowired
    private IProductService productService;//TODO: get all movements je kde ?
	
	private ProductsDataModel model;
	
	@PostConstruct
    public void registerModel() {
		model = new ProductsDataModel(productService.getAllProducts());
	}
	
	public void activated(MainController controller) {
		logger.debug("Activated event");
		
		controller.getForm().setTableModel(model);
	}
	
	public void editFormSave(MainController controller) {
		logger.debug("Save event");
		
		ProductDTO product = controller.getForm().getData().getProductData();
		
		if(product != null){
			logger.debug("Save product " + product.getId());
			if(productService.saveProduct(product)!=null){
				model.update(productService.getAllProducts());
			}else{
				logger.error("Product " + product.getId() + " was not saved");
			}
		}else{
			logger.error("Can't save null product");
		}		   
	}

	public void selectedItem(MainController controller, int index) {
		
		ProductDTO product = model.getRowByIndex(index); 
		
		controller.getForm().editProduct(product);		
	}

    public void deleteItem(MainController controller) {
        ProductDTO product = controller.getForm().getData().getProductData();
        productService.deleteProduct(product.getId());
        model.update(productService.getAllProducts());
    }

    public boolean validate(MainController controller) {
        boolean correct = true;
        List<JTextField> list = controller.getForm().getTextFields().getProductTextFields();
        for (JTextField field : list) {
            InputVerifier iv = field.getInputVerifier();
               if(iv == null)continue;
               if(!iv.verify(field)){
                   correct = false;
               }
        }
        return correct;
    }

	public void itemDoubleClick(MainController controller, int index) {
		// TODO Auto-generated method stub
		
	}

    public void print(int index) {
    }

	public void deactivated(MainController controller) {
		// TODO Auto-generated method stub
		
	}
		

}
