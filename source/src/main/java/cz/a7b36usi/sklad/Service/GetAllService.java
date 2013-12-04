
package cz.a7b36usi.sklad.Service;

import cz.a7b36usi.sklad.BO.UserBO;
import cz.a7b36usi.sklad.BO.PartnerBO;
import cz.a7b36usi.sklad.DTO.UserDTO;
import cz.a7b36usi.sklad.DTO.ZakaznikDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Lukas L.
 */
@Component
public class GetAllService extends AbstractService implements IGetAllService{

    public List<UserDTO> getAllUsers() {
        List<UserBO> bolist = genericDAO.getAll(UserBO.class);
        List<UserDTO> users = new ArrayList<UserDTO>();
        for (UserBO user : bolist) {
            users.add( new UserDTO(user.getId(),user.getUsername(), user.getAcl(),new String(user.getPassword())));
        }
        return users;
    }        

    public List<ZakaznikDTO> getAllZakaznik() {
        List<PartnerBO> bolist = genericDAO.getAll(PartnerBO.class);
        List<ZakaznikDTO> zakaznici = new ArrayList<ZakaznikDTO>();
        for (PartnerBO zakaznik : bolist) {
            zakaznici.add(new ZakaznikDTO(zakaznik.getId(), zakaznik.isIsDodavatel(), zakaznik.isIsOdberatel(), zakaznik.getUlice(), zakaznik.getMesto(),zakaznik.getSpolecnost(), zakaznik.getPsc(), zakaznik.getCisloPopisne()));
        }
        return zakaznici;
    }

}
