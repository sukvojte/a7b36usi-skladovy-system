package cz.a7b36usi.sklad.gui.main;

import javax.swing.JPanel;

import cz.a7b36usi.sklad.Tabs;

public class TabsJPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5181116522842829853L;

	private Tabs tab;
	
	public TabsJPanel(Tabs tab){
		this.tab = tab;  
	}

	/**
	 * @return the tab
	 */
	public Tabs getTab() {
		return tab;
	}
	
	
	
}
