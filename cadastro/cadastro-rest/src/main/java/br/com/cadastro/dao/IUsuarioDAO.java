package br.com.cadastro.dao;

import java.io.Serializable;
import java.util.List;

import br.com.cadastro.model.Usuario;

public interface IUsuarioDAO <T extends Serializable>{

	 public List<Usuario> listUsersAll();
	 public Usuario listUsers(String nomeUsuario, String senha);
	 public boolean insertUser(Usuario usuario);
	 public boolean deleteUser(Usuario usuario);
	 public boolean updateUser(Usuario usuario);
}
