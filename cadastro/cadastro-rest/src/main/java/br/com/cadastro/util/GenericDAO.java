package br.com.cadastro.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/*
 * 
 * @author Thiago
 *
 * Classe Generica que encapsula a obtencao da Session
 */
public class GenericDAO<T> {
	protected EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
