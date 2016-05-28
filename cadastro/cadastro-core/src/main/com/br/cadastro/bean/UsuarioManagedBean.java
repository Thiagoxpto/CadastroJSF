package com.br.cadastro.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import com.br.cadastro.dao.IUsuarioDAO;
import com.br.cadastro.model.Usuario;

@ManagedBean(name = "usuarioManagedBean")
@ViewScoped
public class UsuarioManagedBean {

	@Inject
	IUsuarioDAO usuarioDAO;

	public String envia() {
		Usuario usuario = new Usuario();
		usuario = usuarioDAO.getUser(usuario.getNomeUsuario(),
				usuario.getSenha());
		if (usuario == null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Usuário não encontrado!", "Erro no Login!"));
			return null;
		} else {
			return "/main";
		}

	}
}
