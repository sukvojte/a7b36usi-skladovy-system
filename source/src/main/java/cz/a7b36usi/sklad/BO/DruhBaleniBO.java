
package cz.a7b36usi.sklad.BO;

/**
 *
 * @author Lukas L.
 */
public class DruhBaleniBO extends AbstractBO{
    private String nazev;
    private Double pocet;

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public Double getPocet() {
        return pocet;
    }

    public void setPocet(Double pocet) {
        this.pocet = pocet;
    }
    
    
}
