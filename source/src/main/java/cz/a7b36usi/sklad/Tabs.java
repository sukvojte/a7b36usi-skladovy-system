package cz.a7b36usi.sklad;

import cz.a7b36usi.sklad.Controller.states.AddressBook.AddressBookState;
import cz.a7b36usi.sklad.Controller.states.documents.DocumentsState;
import cz.a7b36usi.sklad.Controller.states.movements.MovementsState;
import cz.a7b36usi.sklad.Controller.states.order.OrdersState;
import cz.a7b36usi.sklad.Controller.states.products.ProductsState;
import cz.a7b36usi.sklad.Controller.states.users.UsersState;

/**
 * Used to store information about current Tab
 * 
 * @author Aleksandr
 */
public enum Tabs {
	ADDRESS_BOOK(AddressBookState.class), ORDERS(OrdersState.class), MOVEMENTS(
			MovementsState.class), DOCUMENTS(DocumentsState.class), WAREHOUSE(
			ProductsState.class), USERS(UsersState.class);

	private Class<?> stateClass;

	private Tabs(Class<?> stateClass) {
		this.stateClass = stateClass;
	}

	/**
	 * @return the stateClass
	 */
	public Class<?> getStateClass() {
		return stateClass;
	}

}
