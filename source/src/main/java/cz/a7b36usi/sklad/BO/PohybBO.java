/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.BO;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

/**
 *
 * @author Peter
 */
@Entity
public class PohybBO extends AbstractBO{
    
    private double cena;
    
    @OneToMany
    private DruhBaleniBO druhBaleni;
    
    @OneToMany
    private SarzeBO sarze;
    
    @Enumerated
    private TypDokladu typDokladu;
    
    @OneToMany
    private ProduktBO produkt;
    
    @OneToMany
    private ZakaznikBO zakaznik;

    public PohybBO() {
    }

    //***************** GETTER SETTER KILOMETER BY PETER ********************************
    
    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
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

    public TypDokladu getTypDokladu() {
        return typDokladu;
    }

    public void setTypDokladu(TypDokladu typDokladu) {
        this.typDokladu = typDokladu;
    }

    public ProduktBO getProdukt() {
        return produkt;
    }

    public void setProdukt(ProduktBO produkt) {
        this.produkt = produkt;
    }

    public ZakaznikBO getZakaznik() {
        return zakaznik;
    }

    public void setZakaznik(ZakaznikBO zakaznik) {
        this.zakaznik = zakaznik;
    }

    
}
