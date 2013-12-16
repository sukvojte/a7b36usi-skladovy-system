package cz.a7b36usi.sklad.Controller.states;

import cz.a7b36usi.sklad.Tabs;

public interface IStateFactory {
	 /**
	  * Returns state object which implements IControllerState by selected tab.
	  * @param activeTab
	  * @return 
	  */
	 IControllerState getStateByTab(Tabs activeTab);
	 /**
	  * Returns default state object which implements IControllerState.
	  * @param activeTab
	  * @return 
	  */	 
	 IControllerState getDefaultState();
}
