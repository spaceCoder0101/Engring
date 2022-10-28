package it.project.dao.generic;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	@PersistenceContext
	protected EntityManager em;
	
	@Override
	public void persist(T obj) {
		em.persist(obj);	
	}
	
	@Override
	public void remove(T obj) {
		em.remove(em.contains(obj)?obj:em.merge(obj));
	}
	
	@Override
	public void merge(T obj) {
		em.merge(obj);	
	}
}
