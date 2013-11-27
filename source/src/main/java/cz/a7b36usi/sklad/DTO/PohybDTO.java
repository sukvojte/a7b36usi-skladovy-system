/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.DTO;

/**
 *
 * @author Peter
 */
public class PohybDTO extends AbstractDTO{
     private double cena;
    private Long druhBaleni;
    private Long sarze;
    private Long typDokladu;
    private Long produkt;
    private Long zakaznik;

    public PohybDTO(Long id,double cena, Long druhBaleni, Long sarze, Long typDokladu, Long produkt, Long zakaznik) {
        this.cena = cena;
        this.druhBaleni = druhBaleni;
        this.sarze = sarze;
        this.typDokladu = typDokladu;
        this.produkt = produkt;
        this.zakaznik = zakaznik;
        this.id=id;
    }

   

    //***************** GETTER SETTER KILOMETER BY PETER ********************************
    
    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Long getDruhBaleni() {
        return druhBaleni;
    }

    public void setDruhBaleni(Long druhBaleni) {
        this.druhBaleni = druhBaleni;
    }

    public Long getSarze() {
        return sarze;
    }

    public void setSarze(Long sarze) {
        this.sarze = sarze;
    }

    public Long getTypDokladu() {
        return typDokladu;
    }

    public void setTypDokladu(Long typDokladu) {
        this.typDokladu = typDokladu;
    }

    public Long getProdukt() {
        return produkt;
    }

    public void setProdukt(Long produkt) {
        this.produkt = produkt;
    }

    public Long getZakaznik() {
        return zakaznik;
    }

    public void setZakaznik(Long zakaznik) {
        this.zakaznik = zakaznik;
    }
}
