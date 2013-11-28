/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.DTO;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Peter
 */
public class ObjednavkaDTO extends AbstractDTO {

    private Date datum;
    private Long druhBaleni;
    private Long sarze;
    private List<Long> polozky;
    private Long zakaznik;

    public ObjednavkaDTO(Long id, Date datum, Long druhBaleni, Long sarze, List<Long> polozky, Long zakaznik) {
        this.datum = datum;
        this.druhBaleni = druhBaleni;
        this.sarze = sarze;
        this.polozky = polozky;
        this.zakaznik = zakaznik;
        this.id = id;
    }

    //***************** GETTER SETTER KILOMETER BY PETER ********************************
    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
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

    public List<Long> getPolozky() {
        return polozky;
    }

    public void setPolozky(List<Long> polozky) {
        this.polozky = polozky;
    }

    public Long getZakaznik() {
        return zakaznik;
    }

    public void setZakaznik(Long zakaznik) {
        this.zakaznik = zakaznik;
    }
}
