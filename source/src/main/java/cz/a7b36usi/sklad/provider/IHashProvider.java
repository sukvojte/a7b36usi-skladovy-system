/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.a7b36usi.sklad.provider;

/**
 *
 * @author Peter
 */
public interface IHashProvider {
    /**
     *  Computes hash for storing password in the database
     * 
     * @param password
     *          Password to store
     * @param salt
     *          Salt to mix with the password
     * @return computed hash value
     * 
     */
    public String computeHash(String password,String salt);
}
