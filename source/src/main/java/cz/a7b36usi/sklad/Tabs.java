package cz.a7b36usi.sklad;

import cz.a7b36usi.sklad.Controller.states.AddressBook.AddressBookState;
import cz.a7b36usi.sklad.Controller.states.users.UsersState;

public enum Tabs {
	ADDRESS_BOOK(AddressBookState.class),
	ORDERS(null),
	MOVEMENTS(null),
	DOCUMENTS(null),
	WAREHOUSE(null),
	USERS(UsersState.class);	
	
	
	private Class<?> stateClass;
	
	private Tabs(Class<?> stateClass){
		this.stateClass = stateClass;
	}

	/**
	 * @return the stateClass
	 */
	public Class<?> getStateClass() {
		return stateClass;
	}
	
	
}
