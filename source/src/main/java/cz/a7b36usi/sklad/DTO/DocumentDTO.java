/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.a7b36usi.sklad.DTO;

import java.util.Date;

import cz.a7b36usi.sklad.BO.DocumentType;

/**
 * 
 * @author Peter
 */
public class DocumentDTO extends AbstractDTO {
	private DocumentType documentType;

	private PartnerDTO partner;

	private int number;

	private Date date;

	public DocumentDTO(Long id, DocumentType documentType, PartnerDTO partner,
			int number, Date date) {
		this.documentType = documentType;
		this.partner = partner;
		this.number = number;
		this.date = new Date(date.getTime());
		this.id = id;
	}

	// ********************* GETTERS AND SETTERS
	// ********************************

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public PartnerDTO getPartner() {
		return partner;
	}

	public void setPartner(PartnerDTO partner) {
		this.partner = partner;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDate() {
		return new Date(date.getTime());
	}

	public void setDate(Date date) {
		this.date = new Date(date.getTime());
	}
}
