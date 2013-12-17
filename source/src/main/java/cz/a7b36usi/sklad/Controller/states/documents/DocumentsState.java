package cz.a7b36usi.sklad.Controller.states.documents;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.Controller.states.IControllerState;
import cz.a7b36usi.sklad.Controller.states.documents.DocumentsDataModel;
import cz.a7b36usi.sklad.DTO.DocumentDTO;
import cz.a7b36usi.sklad.DTO.PartnerDTO;
import cz.a7b36usi.sklad.Service.IDocumentService;
import cz.a7b36usi.sklad.Service.IPartnerService;
import java.util.List;
import javax.swing.InputVerifier;
import javax.swing.JPanel;
import javax.swing.JTextField;

@Component
public class DocumentsState implements IControllerState{

	static final Logger logger = Logger.getLogger(DocumentsState.class);
	
    @Autowired
    private IDocumentService documentService;

    @Autowired
    private IPartnerService partnerService;    
	
	private DocumentsDataModel model;
	
	@PostConstruct
    public void registerModel() {
		model = new DocumentsDataModel(documentService.getAllDocuments());
	}
	
	public void activated(MainController controller) {
		logger.debug("Activated event");
		
		controller.getForm().setTableModel(model);
		controller.getForm().setPartnerList(partnerService.getAllPartners());
	}
	
	public void editFormSave(MainController controller) {
		logger.debug("Save event");
		
		DocumentDTO document = controller.getForm().getData().getDocumentData();
		
		
		
		if(document != null){
			logger.debug("Save document " + document.getId());
			documentService.saveDocument(document);
		        model.update(documentService.getAllDocuments());
		}else{
			logger.error("Can't save null document");
		}
		
	}

	public void selectedItem(MainController controller, int index) {
		
		DocumentDTO document = model.getRowByIndex(index); 
		
		controller.getForm().editDocument(document);		
	}

    public void deleteItem(MainController controller) {
        DocumentDTO document = controller.getForm().getData().getDocumentData();
        documentService.removeDocument(document.getId());
        model.update(documentService.getAllDocuments());
    }

    public boolean validate(MainController controller) {
        boolean correct = true;
        List<JTextField> list = controller.getForm().getTextFields().getDocumentTextFields();
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
		

}
