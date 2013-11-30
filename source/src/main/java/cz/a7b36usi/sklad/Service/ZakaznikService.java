package cz.a7b36usi.sklad.Service;

import cz.a7b36usi.sklad.BO.ZakaznikBO;
import cz.a7b36usi.sklad.DTO.ZakaznikDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Lukas L.
 */
@Component
class ZakaznikService extends AbstractService implements IZakaznikService {

    public List<ZakaznikDTO> getAllZakaznik() {
        List<ZakaznikBO> bolist = genericDAO.getAll(ZakaznikBO.class);
        List<ZakaznikDTO> zakaznici = new ArrayList<ZakaznikDTO>();
        for (ZakaznikBO zakaznik : bolist) {
            zakaznici.add(new ZakaznikDTO(zakaznik.getId(), zakaznik.isIsDodavatel(), zakaznik.isIsOdberatel(), zakaznik.getUlice(), zakaznik.getMesto(),zakaznik.getSpolecnost(), zakaznik.getPsc(), zakaznik.getCisloPopisne()));
        }
        return zakaznici;
    }

    public Long addZakaznik(boolean isDodavatel, boolean isOdberatel, String ulice, String mesto, String spolecnost, int psc, int cisloPopisne) {
        ZakaznikBO zakaznik = new ZakaznikBO();
        zakaznik.setCisloPopisne(cisloPopisne);
        zakaznik.setIsDodavatel(isDodavatel);
        zakaznik.setIsOdberatel(isOdberatel);
        zakaznik.setMesto(mesto);
        zakaznik.setPsc(psc);
        zakaznik.setSpolecnost(spolecnost);
        zakaznik.setUlice(ulice);
        return genericDAO.saveOrUpdate(zakaznik).getId();
    }

	public boolean saveZakaznik(ZakaznikDTO customer) {
		// TODO Auto-generated method stub
		// if customer.id == null, add it into DB!
		// return true if any data changed
                ZakaznikBO zakaznik = new ZakaznikBO();
                zakaznik.setCisloPopisne(customer.getCisloPopisne());
                zakaznik.setIsDodavatel(customer.isIsDodavatel());
                zakaznik.setIsOdberatel(customer.isIsOdberatel());
                zakaznik.setMesto(customer.getMesto());
                zakaznik.setPsc(customer.getPsc());
                zakaznik.setSpolecnost(customer.getSpolecnost());
                zakaznik.setUlice(customer.getUlice());
                zakaznik.setId(customer.getId());
                genericDAO.saveOrUpdate(zakaznik);
		return true;
	}

    public void removeZakaznik(ZakaznikDTO zakaznik) {
        if(zakaznik.getId() != null){        
                genericDAO.removeById(zakaznik.getId(), ZakaznikBO.class);
        }
    }
        
}
