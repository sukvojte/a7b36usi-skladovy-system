/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.BO;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Peter
 */
@Entity
@Table(name="movement")
public class MovementBO extends AbstractBO{
    
    private double cena;
    
    @ManyToOne
    private WrappingTypeBO druhBaleni;
    
    @ManyToOne
    private ProductVersionBO sarze;
    
    @Enumerated
    private DocumentType typDokladu;
    
    @ManyToOne
    private ProductBO produkt;
    
    @ManyToOne
    private PartnerBO zakaznik;

    public MovementBO() {
    }

    //***************** GETTER SETTER KILOMETER BY PETER ********************************
    
    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public WrappingTypeBO getDruhBaleni() {
        return druhBaleni;
    }

    public void setDruhBaleni(WrappingTypeBO druhBaleni) {
        this.druhBaleni = druhBaleni;
    }

    public ProductVersionBO getSarze() {
        return sarze;
    }

    public void setSarze(ProductVersionBO sarze) {
        this.sarze = sarze;
    }

    public DocumentType getTypDokladu() {
        return typDokladu;
    }

    public void setTypDokladu(DocumentType typDokladu) {
        this.typDokladu = typDokladu;
    }

    public ProductBO getProdukt() {
        return produkt;
    }

    public void setProdukt(ProductBO produkt) {
        this.produkt = produkt;
        this.produkt.addPohyb(this);
    }

    public PartnerBO getZakaznik() {
        return zakaznik;
    }

    public void setZakaznik(PartnerBO zakaznik) {
        this.zakaznik = zakaznik;
    }

    
}
