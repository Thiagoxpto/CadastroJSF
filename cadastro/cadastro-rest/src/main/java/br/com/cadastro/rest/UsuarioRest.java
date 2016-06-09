package br.com.cadastro.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.cadastro.dao.IUsuarioDAO;
import br.com.cadastro.model.Usuario;
import jersey.repackaged.com.google.common.collect.Lists;

@Path("/usuario")
public class UsuarioRest {
	@ManagedProperty(value = "#{usuarioDAO}")
	private IUsuarioDAO<Usuario> usuarioDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCartridges() throws JsonParseException, JsonMappingException, IOException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		System.out.println("Servico Rest");
		try {
			usuarios = usuarioDAO.listUsersAll();
			System.out.println("lista" + usuarios.size());
			GenericEntity<List<Usuario>> entity = new GenericEntity<List<Usuario>>(Lists.newArrayList(usuarios)) {
			};
			return Response.status(200).entity("teste").build();
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
	}

}