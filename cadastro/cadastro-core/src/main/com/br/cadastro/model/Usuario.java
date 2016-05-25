package com.br.cadastro.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_USER")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_USER", nullable = false, unique = true)
	private int id;

	@Column(name = "NM_USER", nullable = false, unique = true)
	private String nomeUsuario;

	@Column(name = "NR_PASSWORD", nullable = false, unique = false)
	private String senha;

	@Column(name = "DT_LAST_ACESS", unique = true)
	@Temporal(TemporalType.DATE)
	private Date ultimoAcesso;

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}
}
