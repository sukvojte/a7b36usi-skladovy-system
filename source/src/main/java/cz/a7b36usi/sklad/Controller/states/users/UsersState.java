package cz.a7b36usi.sklad.Controller.states.users;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.InputVerifier;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.Controller.states.IControllerState;
import cz.a7b36usi.sklad.Controller.states.AddressBook.AddressBookState;
import cz.a7b36usi.sklad.DTO.UserDTO;
import cz.a7b36usi.sklad.Service.IUserService;
import cz.a7b36usi.sklad.validators.UserNameValidator;

@Component
public class UsersState implements IControllerState {

    static final Logger logger = Logger.getLogger(AddressBookState.class);

    @Autowired
    private IUserService userService;

    private UsersDataModel model;

    @PostConstruct
    public void registerModel() {
        model = new UsersDataModel(userService.getAllUsers());
    }

    public void activated(MainController controller) {
        logger.debug("Activated event");

        controller.getForm().setTableModel(model);

    }

    public void editFormSave(MainController controller) {
        logger.debug("Save event");
        UserDTO user = controller.getForm().getData().getUserData();

        if (user != null) {
            logger.debug("Save customer " + user.getId());
            if (userService.updateUser(user)) {
                model.update(userService.getAllUsers());
            } else {
                logger.error("Customer " + user.getId() + " was not saved");
            }
        } else {
            logger.error("Can't save null customer");
        }
    }

    public void selectedItem(MainController controller, int index) {
        UserDTO user = model.getRowByIndex(index);

        controller.getForm().editUser(user);
    }

    public void deleteItem(MainController controller) {
        UserDTO user = controller.getForm().getData().getUserData();
        userService.deleteUser(user.getId());
        model.update(userService.getAllUsers());
    }

    public boolean validate(MainController controller) {
        boolean correct = true;
        List<JTextField> list = controller.getForm().getTextFields()
                .getUsersTextFields();
        for (JTextField field : list) {
            if (field.getName() != null
                    && field.getName().equals("uzivatelskeJmeno")) {
                UserDTO user = userService.getUserByUsername(field.getText());
                if (user != null
                        && user.getUsername().equals(
                                ((UserNameValidator) field.getInputVerifier())
                                .getValue())) {
                    ((UserNameValidator) field.getInputVerifier())
                            .incorrect(field);
                    correct = false;
                    continue;
                } else {
                    ((UserNameValidator) field.getInputVerifier())
                            .correct(field);
                    continue;
                }
            }
            InputVerifier iv = field.getInputVerifier();
            if (iv == null) {
                continue;
            }
            if (!iv.verify(field)) {
                correct = false;
            }
        }
        return correct;
    }

    public void itemDoubleClick(MainController controller, int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void print(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deactivated(MainController controller) {

    }

	public void productVersionEdit(MainController ctrl, int index) {
		// TODO Auto-generated method stub
		
	}

	public void wrappingTypeEdit(MainController ctrl, int index) {
		// TODO Auto-generated method stub
		
	}

}
