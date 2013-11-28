
package cz.a7b36usi.sklad.Controller;

import cz.a7b36usi.sklad.Controller.ifaces.ITabController;
import cz.a7b36usi.sklad.Service.IUserService;
import cz.a7b36usi.sklad.Service.IZakaznikService;
import cz.a7b36usi.sklad.tableutils.AdresarTableModel;
import cz.a7b36usi.sklad.tableutils.UsersTableModel;
import javax.swing.table.TableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Lukas L.
 */
@Component
public class TabController implements ITabController{
    @Autowired
    private IUserService userService;
    
    @Autowired
    private IZakaznikService zakaznikService;
    
       public TableModel getTableModel(int indexTab){
        System.out.println("index"+indexTab);
        switch(indexTab){
            case 0 : return new AdresarTableModel(zakaznikService.getAllZakaznik());
            case 4 : return new UsersTableModel(userService.getAllUsers());
        }
        return null;
    }
    

}
