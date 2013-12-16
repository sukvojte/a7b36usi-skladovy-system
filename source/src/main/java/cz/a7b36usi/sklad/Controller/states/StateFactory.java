package cz.a7b36usi.sklad.Controller.states;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Tabs;
/*
 * StateFacotory is responsible for loading states from 
 * ApplicationContext and saves them into HashMap for using them later.
 */
@Component
public class StateFactory implements IStateFactory {

	static final Logger logger = Logger.getLogger(StateFactory.class);
	
	@Autowired
	private ApplicationContext appContext;
	
	private HashMap<Tabs, IControllerState> states;
	private IControllerState empty;
	
	private StateFactory(){
		states = new HashMap<Tabs, IControllerState>();
		empty = new EmptyState();
	}
	
	public IControllerState getStateByTab(Tabs activeTab) {
		
		IControllerState state = empty;
		
		if(states.containsKey(activeTab)){
			state = states.get(activeTab);
			logger.debug("Set state " + state.getClass());
		}else{
			Class<?> className = activeTab.getStateClass();
			if(className != null){
				logger.debug("Allocate new class " + className);
				state = (IControllerState)appContext.getBean(className);
				states.put(activeTab, state);
			}else{
				logger.warn("State " + activeTab + " not found!");
			}
		}
		
		return state;
	}
	
	public IControllerState getDefaultState(){
		return empty;
	}

}
