/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.BO;

import javax.persistence.Entity;

/**
 *
 * @author Peter
 */
@Entity
public class ZakaznikBO extends AbstractBO {

    private boolean isDodavatel, isOdberatel;
    private String ulice, mesto, spolecnost;
    private int psc, cisloPopisne;

    public ZakaznikBO() {
    }
    
    //***************** GETTER SETTER KILOMETER BY PETER ********************************

    public boolean isIsDodavatel() {
        return isDodavatel;
    }

    public void setIsDodavatel(boolean isDodavatel) {
        this.isDodavatel = isDodavatel;
    }

    public boolean isIsOdberatel() {
        return isOdberatel;
    }

    public void setIsOdberatel(boolean isOdberatel) {
        this.isOdberatel = isOdberatel;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getSpolecnost() {
        return spolecnost;
    }

    public void setSpolecnost(String spolecnost) {
        this.spolecnost = spolecnost;
    }

    public int getPsc() {
        return psc;
    }

    public void setPsc(int psc) {
        this.psc = psc;
    }

    public int getCisloPopisne() {
        return cisloPopisne;
    }

    public void setCisloPopisne(int cisloPopisne) {
        this.cisloPopisne = cisloPopisne;
    }
    
    
    
}
