
package cz.a7b36usi.sklad.gui;

import cz.a7b36usi.sklad.DTO.PartnerDTO;

/**
 *
 * @author Lukas Lowinger
 */
public class ComboBoxPartnerItem {

	private PartnerDTO partner;

	public ComboBoxPartnerItem(PartnerDTO partner) {
		this.partner = partner;
	}

	/**
	 * @return the partner
	 */
	public PartnerDTO getProduct() {
		return partner;
	}

	@Override
	public String toString() {
		return partner.getSpolecnost();
	}

}
