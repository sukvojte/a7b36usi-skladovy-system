package cz.a7b36usi.sklad.Service;

import cz.a7b36usi.sklad.BO.PartnerBO;
import cz.a7b36usi.sklad.DTO.PartnerDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Lukas L.
 */
@Component
class PartnerService extends AbstractService implements IPartnerService {

    public List<PartnerDTO> getAllPartners() {
	List<PartnerBO> bolist = genericDAO.getAll(PartnerBO.class);
	List<PartnerDTO> partners = new ArrayList<PartnerDTO>();
	for (PartnerBO zakaznik : bolist) {
	    partners.add(new PartnerDTO(zakaznik.getId(), zakaznik.isIsDodavatel(), zakaznik.isIsOdberatel(), zakaznik.getUlice(), zakaznik.getMesto(), zakaznik.getSpolecnost(), zakaznik.getPsc(), zakaznik.getCisloPopisne()));
	}
	return partners;
    }

    public Long addPartner(boolean isDodavatel, boolean isOdberatel, String ulice, String mesto, String spolecnost, int psc, int cisloPopisne) {
	PartnerBO partner = new PartnerBO();
	partner.setCisloPopisne(cisloPopisne);
	partner.setIsDodavatel(isDodavatel);
	partner.setIsOdberatel(isOdberatel);
	partner.setMesto(mesto);
	partner.setPsc(psc);
	partner.setSpolecnost(spolecnost);
	partner.setUlice(ulice);
	return genericDAO.saveOrUpdate(partner).getId();
    }

    public boolean savePartner(PartnerDTO customer) {
	// TODO Auto-generated method stub
	// if customer.id == null, add it into DB!
	// return true if any data changed
	PartnerBO partner = new PartnerBO();
	partner.setCisloPopisne(customer.getCisloPopisne());
	partner.setIsDodavatel(customer.isIsDodavatel());
	partner.setIsOdberatel(customer.isIsOdberatel());
	partner.setMesto(customer.getMesto());
	partner.setPsc(customer.getPsc());
	partner.setSpolecnost(customer.getSpolecnost());
	partner.setUlice(customer.getUlice());
	partner.setId(customer.getId());
	genericDAO.saveOrUpdate(partner);
	return true;
    }

    public void removePartner(PartnerDTO partner) {
	if (partner.getId() != null) {
	    genericDAO.removeById(partner.getId(), PartnerBO.class);
	}
    }
}
