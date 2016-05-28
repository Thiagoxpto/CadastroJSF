package com.br.cadastro.dao;

import com.br.cadastro.model.Usuario;

public interface IUsuarioDAO {

	 public Usuario getUser(String nomeUsuario, String senha);
	 public boolean insertUser(Usuario usuario);
	 public boolean deleteUser(Usuario usuario);
	 public boolean updateUser(Usuario usuario);
}
