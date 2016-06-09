package br.com.cadastro.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cadastro.dao.IUsuarioDAO;
import br.com.cadastro.model.Usuario;
import br.com.cadastro.util.GenericDAO;

@Repository("usuarioDAO")
@Transactional
public class UsuarioDAO extends GenericDAO<Usuario> implements IUsuarioDAO<Usuario> {

	public List<Usuario> listUsersAll() {
		System.out.println("listUsersAll");
		@SuppressWarnings("unchecked")
		List<Usuario> resultList = (List<Usuario>) entityManager.createQuery("SELECT * FROM TB_USER").getResultList();
		System.out.println("Result listUsersAll" + resultList.size());
		return resultList;
	}

	public Usuario listUsers(String nomeUsuario, String senha) {
		Usuario usuario = (Usuario) entityManager
				.createQuery("SELECT u FROM TB_USER u where u.NM_USER = :name and u.NR_PASSWORD = :senha")
				.setParameter("name", nomeUsuario).setParameter("senha", senha).getSingleResult();
		return usuario;
	}

	public boolean insertUser(Usuario usuario) {
		entityManager.persist(usuario);
		return true;
	}

	public boolean deleteUser(Usuario usuario) {
		entityManager.remove(usuario);
		return true;
	}

	public boolean updateUser(Usuario usuario) {
		entityManager.merge(usuario);
		return false;
	}

}
