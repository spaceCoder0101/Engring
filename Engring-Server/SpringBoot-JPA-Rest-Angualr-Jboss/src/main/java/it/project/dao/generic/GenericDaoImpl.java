package it.project.dao.generic;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	@PersistenceContext
	protected EntityManager em;
	
	@Override
	@Transactional
	public void persist(T obj) {
		em.persist(obj);	
	}
	
	@Override
	@Transactional
	public void remove(T obj) {
		em.remove(em.contains(obj)?obj:em.merge(obj));
	}
	
	@Override
	@Transactional
	public void merge(T obj) {
		em.merge(obj);	
	}
}
