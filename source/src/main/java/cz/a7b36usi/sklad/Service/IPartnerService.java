package cz.a7b36usi.sklad.Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cz.a7b36usi.sklad.DTO.PartnerDTO;

/**
 * 
 * @author Lukas L.
 */
public interface IPartnerService {

	/**
	 * Gets all partners
	 * 
	 * @return list of PartnerDTO
	 */
	@Transactional(readOnly = true)
	public List<PartnerDTO> getAllPartners();

	/**
	 * Adds partner to database
	 * 
	 * @param isDodavatel
	 * @param isOdberatel
	 * @param ulice
	 * @param mesto
	 * @param spolecnost
	 * @param psc
	 * @param cisloPopisne
	 * @return id of partner entity
	 */
	public Long addPartner(boolean isDodavatel, boolean isOdberatel,
			String ulice, String mesto, String spolecnost, int psc,
			int cisloPopisne);

	/**
	 * Persists partner in database
	 * 
	 * @param customer
	 *            customer to be persist
	 */
	public boolean savePartner(PartnerDTO customer);

	/**
	 * Delete partner entity from database
	 * 
	 * @param customer
	 *            customer to be removed
	 */
	public void removePartner(PartnerDTO customer);
}
