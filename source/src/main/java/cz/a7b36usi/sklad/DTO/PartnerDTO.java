/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.DTO;

/**
 * 
 * @author Peter
 */
public class PartnerDTO extends AbstractDTO {
	private boolean isDodavatel, isOdberatel;
	private String ulice, mesto, spolecnost;
	private int psc, cisloPopisne;

	public PartnerDTO(Long id, boolean isDodavatel, boolean isOdberatel,
			String ulice, String mesto, String spolecnost, int psc,
			int cisloPopisne) {
		this.isDodavatel = isDodavatel;
		this.isOdberatel = isOdberatel;
		this.ulice = ulice;
		this.mesto = mesto;
		this.spolecnost = spolecnost;
		this.psc = psc;
		this.cisloPopisne = cisloPopisne;
		this.id = id;
	}

	// ***************** GETTER SETTER KILOMETER BY PETER
	// ********************************

	public boolean isIsDodavatel() {
		return isDodavatel;
	}

	public void setIsDodavatel(boolean isDodavatel) {
		this.isDodavatel = isDodavatel;
	}

	public boolean isIsOdberatel() {
		return isOdberatel;
	}

	public void setIsOdberatel(boolean isOdberatel) {
		this.isOdberatel = isOdberatel;
	}

	public String getUlice() {
		return ulice;
	}

	public void setUlice(String ulice) {
		this.ulice = ulice;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getSpolecnost() {
		return spolecnost;
	}

	public void setSpolecnost(String spolecnost) {
		this.spolecnost = spolecnost;
	}

	public int getPsc() {
		return psc;
	}

	public void setPsc(int psc) {
		this.psc = psc;
	}

	public int getCisloPopisne() {
		return cisloPopisne;
	}

	public void setCisloPopisne(int cisloPopisne) {
		this.cisloPopisne = cisloPopisne;
	}

	@Override
	public String toString() {
		return spolecnost;
	}

}
