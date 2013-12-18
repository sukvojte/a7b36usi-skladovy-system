/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.DTO;

/**
 *
 * @author Peter
 */
public class MovementDTO extends AbstractDTO{
    private double price;

    private Long wrapping;

    private Long version;
    
    private int quantity;

    private ProductDTO produkt;

    private DocumentDTO document;

    public MovementDTO(Long id,double price, Long wrapping, Long version, ProductDTO produkt, DocumentDTO document, int quant) {
        this.price = price;
        this.wrapping = wrapping;
        this.version = version;
        this.produkt = produkt;
        this.document = document;
        this.id=id;
	this.quantity = quant;
    }
//**************** GETTERS AND SETTERS ******************************
    
    public MovementDTO() {
		// TODO Auto-generated constructor stub
	}

	public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getWrapping() {
        return wrapping;
    }

    public void setWrapping(Long wrapping) {
        this.wrapping = wrapping;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public ProductDTO getProdukt() {
        return produkt;
    }

    public void setProdukt(ProductDTO produkt) {
        this.produkt = produkt;
    }

    public DocumentDTO getDocument() {
        return document;
    }

    public void setDocument(DocumentDTO document) {
        this.document = document;
    }

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

    
    
  
}
