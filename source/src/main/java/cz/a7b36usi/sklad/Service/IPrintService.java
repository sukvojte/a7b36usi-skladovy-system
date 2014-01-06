package cz.a7b36usi.sklad.Service;

/**
 * 
 * @author Lukas L.
 */
public interface IPrintService {
	/**
     *  Saves order in the .pdf document to print
     * 
     * @param orderId
     * @return
     */
    public boolean printOrder(Long orderId);
}
