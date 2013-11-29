package cz.a7b36usi.sklad.Controller.states;

import cz.a7b36usi.sklad.Tabs;

public interface IStateFactory {
	 IControllerState getStateByTab(Tabs activeTab);
	 IControllerState getDefaultState();
}
