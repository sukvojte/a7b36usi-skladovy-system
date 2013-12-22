package cz.a7b36usi.sklad.ifaces;

public interface RecieveListener<T> {

	/**
	 * Adds IMainGuiListener
	 * 
	 * @param listener
	 */
	void addListeners(T listener);

	/**
	 * Removes IMainGuiListener
	 * 
	 * @param listener
	 */
	void removeListeners(T listener);
}
