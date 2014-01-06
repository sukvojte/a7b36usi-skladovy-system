package cz.a7b36usi.sklad.gui.documentitems.ifaces;

/**
 * Listens on events with document items
 * 
 * @author Aleksandr
 */
public interface IDocumentItemsGuiListener {
    /**
     * Listen method on save action
     */
    void save();
    
    /**
     *  Listen method on click action
     * 
     * @param index
     * 
     */
    void click(int index);

    /**
     * Listen method on delete action
     */
    void delete();
}
