package cz.a7b36usi.sklad.Service;

import cz.a7b36usi.sklad.DTO.UserDTO;
import cz.a7b36usi.sklad.DTO.ZakaznikDTO;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lukas L.
 */
public interface IGetAllService {

    @Transactional(readOnly = true)
    public List<UserDTO> getAllUsers();

    @Transactional(readOnly = true)
    public List<ZakaznikDTO> getAllZakaznik();
}
