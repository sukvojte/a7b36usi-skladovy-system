package cz.a7b36usi.sklad.gui.login.ifaces;

public interface ILogging {

	/**
	 * Set visible logging form
	 * 
	 * @param state
	 */
	void setVisible(boolean state);

	/**
	 * Shows error text
	 * 
	 * @param text
	 */
	void showError(String text);
}
