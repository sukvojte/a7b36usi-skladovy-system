package cz.a7b36usi.sklad.Service;

import cz.a7b36usi.sklad.DTO.UserDTO;
import cz.a7b36usi.sklad.DTO.ZakaznikDTO;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lukas L.
 */
public interface IZakaznikService {

    @Transactional(readOnly = true)
    public List<ZakaznikDTO> getAllZakaznik();
    
    public Long addZakaznik(boolean isDodavatel, boolean isOdberatel, String ulice, String mesto, String spolecnost, int psc, int cisloPopisne);
}
