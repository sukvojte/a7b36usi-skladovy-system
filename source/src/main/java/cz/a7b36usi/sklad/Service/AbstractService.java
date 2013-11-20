/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Service;

import cz.a7b36usi.sklad.DAO.IGenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Peter
 */
@Transactional
public abstract class AbstractService {
    @Autowired
    protected IGenericDAO genericDAO;
    public void setGenericDao(IGenericDAO genericDao) {
        this.genericDAO = genericDao;
    }

    public IGenericDAO getGenericDao() {
        return genericDAO;
    }    
}
