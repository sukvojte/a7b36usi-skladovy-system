/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.BO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Peter
 */

/**
 * Thist entity represents document
 */
@Entity
@Table(name = "document")
public class DocumentBO extends AbstractBO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3244643732740986115L;

	@Enumerated
	private DocumentType documentType;

	@ManyToOne
	@JoinColumn(nullable = false)
	private PartnerBO partner;

	private int number;

	@Temporal(TemporalType.DATE)
	@Column(name = "creationDate")
	private Date date;

	public DocumentBO() {

	}

	// ************************************GETTERS AND
	// SETTERS***************************************************
	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public PartnerBO getPartner() {
		return partner;
	}

	public void setPartner(PartnerBO partner) {
		this.partner = partner;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
