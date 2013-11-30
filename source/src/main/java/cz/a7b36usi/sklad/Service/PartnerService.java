package cz.a7b36usi.sklad.Service;

import cz.a7b36usi.sklad.BO.PartnerBO;
import cz.a7b36usi.sklad.DTO.ZakaznikDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Lukas L.
 */
@Component
class PartnerService extends AbstractService implements IPartnerService {

    public List<ZakaznikDTO> getAllZakaznik() {
        List<PartnerBO> bolist = genericDAO.getAll(PartnerBO.class);
        List<ZakaznikDTO> zakaznici = new ArrayList<ZakaznikDTO>();
        for (PartnerBO zakaznik : bolist) {
            zakaznici.add(new ZakaznikDTO(zakaznik.getId(), zakaznik.isIsDodavatel(), zakaznik.isIsOdberatel(), zakaznik.getUlice(), zakaznik.getMesto(),zakaznik.getSpolecnost(), zakaznik.getPsc(), zakaznik.getCisloPopisne()));
        }
        return zakaznici;
    }

    public Long addZakaznik(boolean isDodavatel, boolean isOdberatel, String ulice, String mesto, String spolecnost, int psc, int cisloPopisne) {
        PartnerBO zakaznik = new PartnerBO();
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
		return false;
	}
}
