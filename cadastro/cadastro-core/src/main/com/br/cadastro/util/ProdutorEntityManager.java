package com.br.cadastro.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author thiago.tavares 
 * Factory para EntityManager
 */
public class ProdutorEntityManager {

	public static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("cadastro");

	/**
	 * metodo que iniciara somente a cada request
	 * @return
	 */
	@Produces
	@RequestScoped
	public EntityManager criaEntityManager() {
		return factory.createEntityManager();
	}

	/**
	 * metodo que finalizara o objeto ao final de cada request
	 * @param manager
	 */
	public void finaliza(@Disposes EntityManager manager) {
		manager.close();
	}
}
