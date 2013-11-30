/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.BO;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Peter
 */
@Entity
@Table(name="order")
public class OrderBO extends AbstractBO{
    @Temporal(TemporalType.DATE)
    private Date datum;
    
    @ManyToOne
    private WrappingTypeBO druhBaleni;
    
    @ManyToOne
    private ProductVersionBO sarze;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<ArticleBO> polozky;
    
    @ManyToOne
    private PartnerBO zakaznik;

    public OrderBO() {
    }

    
    //***************** GETTER SETTER KILOMETER BY PETER ********************************
    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
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

    public List<ArticleBO> getPolozky() {
        return polozky;
    }

    public void setPolozky(List<ArticleBO> polozky) {
        this.polozky = polozky;
    }

    public PartnerBO getZakaznik() {
        return zakaznik;
    }

    public void setZakaznik(PartnerBO zakaznik) {
        this.zakaznik = zakaznik;
    }
    
    
}
