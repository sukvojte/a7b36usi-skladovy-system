package cz.a7b36usi.sklad;

import cz.a7b36usi.sklad.Controller.states.AddressBookState;

public enum Tabs {
	ADDRESS_BOOK(AddressBookState.class),
	ORDERS(null),
	MOVEMENTS(null),
	WAREHOUSE(null),
	USERS(null);	
	
	
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
