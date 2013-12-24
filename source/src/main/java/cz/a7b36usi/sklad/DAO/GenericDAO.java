/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.BO.AbstractBO;

/**
 * 
 * @author Peter
 */
@Component("genericDAO")
public class GenericDAO implements IGenericDAO {

	@Autowired
	protected EntityManagerFactory entityManagerfactory;

	protected EntityManager getEntityManager() {
		EntityManager em = EntityManagerFactoryUtils
				.getTransactionalEntityManager(entityManagerfactory);
		return em;
	}

	@SuppressWarnings("unchecked")
	public <ENTITY> List<ENTITY> getAll(Class<ENTITY> clazz) {
		return getEntityManager().createQuery(
				"SELECT e FROM " + clazz.getSimpleName() + " e")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public <ENTITY> List<ENTITY> getAllOrderedDesc(String property,
			Class<ENTITY> clazz) {
		CriteriaQuery<ENTITY> query = getEntityManager().getCriteriaBuilder()
				.createQuery(clazz);
		Root root = query.from(clazz);
		query.select(root);
		query.orderBy(getEntityManager().getCriteriaBuilder().desc(
				root.get(property)));
		return getEntityManager().createQuery(query).getResultList();

	}

	@SuppressWarnings("unchecked")
	public <ENTITY> List<ENTITY> getAllOrderedAsc(String property,
			Class<ENTITY> clazz) {
		CriteriaQuery<ENTITY> query = getEntityManager().getCriteriaBuilder()
				.createQuery(clazz);
		Root root = query.from(clazz);
		query.select(root);
		query.orderBy(getEntityManager().getCriteriaBuilder().asc(
				root.get(property)));
		return getEntityManager().createQuery(query).getResultList();
	}

	@SuppressWarnings("unchecked")
	public <ENTITY> List<ENTITY> getByProperty(String property, Object value,
			Class<ENTITY> clazz) {
		String queryString = "SELECT e FROM " + clazz.getSimpleName()
				+ " e WHERE e." + property + " = :value";
		return getEntityManager().createQuery(queryString)
				.setParameter("value", value).getResultList();
	}

	public <ENTITY extends AbstractBO> void removeById(long id,
			Class<ENTITY> clazz) {
		ENTITY e = getEntityManager().find(clazz, id);
		if (e != null) {
			getEntityManager().remove(e);
		}
	}

	public <ENTITY extends AbstractBO> void remove(ENTITY o) {
		getEntityManager().remove(o);
	}

	@SuppressWarnings("unchecked")
	public <ENTITY> ENTITY getById(Long id, Class<ENTITY> clazz) {
		return getEntityManager().find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public <ENTITY> ENTITY loadById(long id, Class<ENTITY> clazz) {
		return (ENTITY) ((Session) getEntityManager().getDelegate()).load(
				clazz, id);
	}

	public <ENTITY extends AbstractBO> ENTITY saveOrUpdate(ENTITY o) {
		if (o.getId() == null) {
			getEntityManager().persist(o);
		} else {
			getEntityManager().merge(o);
		}
		return o;
	}

	public <ENTITY> ENTITY getByPropertyUnique(String property, Object value,
			Class<ENTITY> clazz) {
		ENTITY e;
		if (value == null) {
			e = clazz.cast(getEntityManager().createQuery(
					"FROM " + clazz.getSimpleName() + " WHERE " + property
							+ " IS NULL").getSingleResult());
		} else {
			e = clazz.cast(getEntityManager()
					.createQuery(
							"FROM " + clazz.getSimpleName() + " WHERE "
									+ property + " = :value")
					.setParameter("value", value).getSingleResult());
		}
		return e;
	}

	public Long getCount(Class clazz) {
		throw new IllegalStateException("Not implemented yet");
	}

	public <ENTITY> List<ENTITY> getPage(int from, int maxResults,
			Class<ENTITY> clazz) {
		throw new IllegalStateException("Not implemented yet");
	}

	public <ENTITY> List<ENTITY> getPage(int first, int rows, String sortBy,
			boolean ascending, Class<ENTITY> clazz) {
		throw new IllegalStateException("Not implemented yet");
	}

	public void merge(Object o) {
		throw new IllegalStateException("Not implemented yet");
	}
}
