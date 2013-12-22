/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.DAO;

/**
 *
 * @author Peter
 */
import java.util.List;

import cz.a7b36usi.sklad.BO.AbstractBO;

/**
 * 
 * @author Peter
 */
public interface IGenericDAO {

	/**
	 * Returns all objects with type of class parameter sorted descending by id
	 * 
	 * @param clazz
	 * @return all objects from clazz parameter
	 */
	public <ENTITY> List<ENTITY> getAll(Class<ENTITY> clazz);

	/**
	 * Vrati stranku entit zacinajici from o velikosti maxResults
	 * 
	 * @param <ENTITY>
	 *            typovy parametr
	 * @param from
	 *            index uvodni entity
	 * @param maxResults
	 *            pocet entit na strance
	 * @param clazz
	 *            trida korespondujici s typem
	 * @return maxResults entit
	 */
	public <ENTITY> List<ENTITY> getPage(int from, int maxResults,
			Class<ENTITY> clazz);

	/**
	 * Delete object by id
	 * 
	 * @param id
	 *            objec's id to delete
	 */
	public <ENTITY extends AbstractBO> void removeById(long id,
			Class<ENTITY> clazz);

	/**
	 * Vrati pocet entit dane tridy
	 * 
	 * @param clazz
	 *            trida
	 * @return pocet
	 */
	public Long getCount(Class clazz);

	/**
	 * Delete entity
	 * 
	 * @param o
	 *            entity to delete
	 */
	public <ENTITY extends AbstractBO> void remove(ENTITY o);

	/**
	 * Save entity when its id is null, or update otherwise
	 * 
	 * @param <ENTITY>
	 * @param o
	 * @return attached object
	 */
	public <ENTITY extends AbstractBO> ENTITY saveOrUpdate(ENTITY o);

	/**
	 * Returns objects (by get) with type of class clazz by id
	 * 
	 * @param id
	 *            id objektu k vraceni
	 * @return objekt identifikovany id, @null pokud neexistuje
	 */
	public <ENTITY> ENTITY getById(Long id, Class<ENTITY> clazz);

	/**
	 * Loads entity from database by id
	 * 
	 * @param <ENTITY>
	 * @param id
	 * @param clazz
	 * @return
	 */
	public <ENTITY> ENTITY loadById(long id, Class<ENTITY> clazz);

	/**
	 * Returns all objects with type of class parameter sorted descending by
	 * property
	 * 
	 * @param property
	 * @param clazz
	 * @return
	 */
	public <ENTITY> List<ENTITY> getAllOrderedDesc(String property,
			Class<ENTITY> clazz);

	/**
	 * Returns all objects with type of class parameter sorted ascending by
	 * property
	 * 
	 * @param property
	 * @param clazz
	 * @return
	 */
	public <ENTITY> List<ENTITY> getAllOrderedAsc(String property,
			Class<ENTITY> clazz);

	/**
	 * Returns all objects with type of class parameter whose property is equal
	 * to object parameter sorted descending by property
	 * 
	 * @param property
	 *            property, which we compare
	 * @param value
	 *            value, which we compare
	 * @return all records fulfilling a condition
	 */
	public <ENTITY> List<ENTITY> getByProperty(String property, Object value,
			Class<ENTITY> clazz);

	/**
	 * Get unique entity by property which is equal to value
	 * 
	 * @param <ENTITY>
	 * @param property
	 * @param value
	 * @param clazz
	 * @return
	 */
	public <ENTITY> ENTITY getByPropertyUnique(String property, Object value,
			Class<ENTITY> clazz);

	/**
	 * Get all entities by property
	 * 
	 * @param property
	 *            the property to select
	 * @param value
	 *            value of the property
	 * @param sortBy
	 *            parametr, opdle ktereho dojde k razeni
	 * @param ascending
	 *            priznak toho, jestli razeni bude vzestupne nebo sestupne, @true
	 *            vzestupne, @false sestupne
	 * @return
	 */
	public <ENTITY> List<ENTITY> getPage(int first, int rows, String sortBy,
			boolean ascending, Class<ENTITY> clazz);

}
