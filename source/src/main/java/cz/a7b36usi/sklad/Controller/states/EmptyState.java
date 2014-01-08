package cz.a7b36usi.sklad.Controller.states;

import org.apache.log4j.Logger;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;

public class EmptyState implements IControllerState {
	static final Logger logger = Logger.getLogger(EmptyState.class);

	private BaseDataModel<Object> model;

	public EmptyState() {
		model = new BaseDataModel<Object>(null) {
			private static final long serialVersionUID = 3166346861380415669L;

			@Override
			public Object getColumnValue(Object row, int index) {
				return "";
			}

			@Override
			public int getRowCount() {
				return 0;
			}

			@Override
			public int getColumnCount() {
				return 0;
			}

		};
	}

	public void activated(MainController controller) {
		logger.debug("Activated event");
		controller.getForm().setTableModel(model);
	}

	public void editFormSave(MainController controller) {
		logger.warn("Save event");
	}

	public void selectedItem(MainController controller, int index) {
		logger.warn("Selected index " + index + " how is it possible ???");
	}

	public void deleteItem(MainController controller) {
		logger.warn("deleting user");
	}

	public boolean validate(MainController controller) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void itemDoubleClick(MainController controller, int index) {
		logger.warn("double click");
	}

	public void print(int index) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void deactivated(MainController controller) {

	}

	public void productVersionEdit(MainController ctrl, int index) {
		
	}

	public void wrappingTypeEdit(MainController ctrl, int index) {
		
	}

}
