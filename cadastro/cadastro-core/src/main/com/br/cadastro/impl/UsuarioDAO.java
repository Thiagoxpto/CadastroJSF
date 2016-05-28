package com.br.cadastro.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.br.cadastro.dao.IUsuarioDAO;
import com.br.cadastro.model.Usuario;

public class UsuarioDAO implements IUsuarioDAO {

	//@PersistenceContext(unitName = "cadastro")
	EntityManager entityManager;
	public static final Logger log = LoggerFactory.getLogger(UsuarioDAO.class);

	@Override
	public Usuario getUser(String nomeUsuario, String senha) {
		Usuario usuario = (Usuario) entityManager
				.createQuery(
						"SELECT u FROM TB_USER u where u.NM_USER = :name and u.NR_PASSWORD = :senha")
				.setParameter("name", nomeUsuario).setParameter("senha", senha)
				.getSingleResult();
		return usuario;
	}

	@Override
	public boolean insertUser(Usuario usuario) {
		entityManager.persist(usuario);
		return true;
	}

	@Override
	public boolean deleteUser(Usuario usuario) {
		entityManager.remove(usuario);
		return true;
	}

	@Override
	public boolean updateUser(Usuario usuario) {
		entityManager.merge(usuario);
		return false;
	}

}
