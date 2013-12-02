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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Peter
 */
@Entity
public class ObjednavkaBO extends AbstractBO{
    @Temporal(TemporalType.DATE)
    private Date datum;
    
    @ManyToOne
    private DruhBaleniBO druhBaleni;
    
    @ManyToOne
    private SarzeBO sarze;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<PolozkaBO> polozky;
    
    @ManyToOne
    private ZakaznikBO zakaznik;

    public ObjednavkaBO() {
    }

    
    //***************** GETTER SETTER KILOMETER BY PETER ********************************
    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public DruhBaleniBO getDruhBaleni() {
        return druhBaleni;
    }

    public void setDruhBaleni(DruhBaleniBO druhBaleni) {
        this.druhBaleni = druhBaleni;
    }

    public SarzeBO getSarze() {
        return sarze;
    }

    public void setSarze(SarzeBO sarze) {
        this.sarze = sarze;
    }

    public List<PolozkaBO> getPolozky() {
        return polozky;
    }

    public void setPolozky(List<PolozkaBO> polozky) {
        this.polozky = polozky;
    }

    public ZakaznikBO getZakaznik() {
        return zakaznik;
    }

    public void setZakaznik(ZakaznikBO zakaznik) {
        this.zakaznik = zakaznik;
    }
    
    
}
