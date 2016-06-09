package br.com.cadastro.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cadastro.dao.IUsuarioDAO;

@Controller
@RequestMapping("/usuario")
public class UsuarioRest {
	@Autowired
	private IUsuarioDAO<?> usuarioDAO;

	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCartridges() throws JsonParseException, JsonMappingException, IOException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		System.out.println("INICIO");
		try {
			usuarios = usuarioDAO.listUsersAll();
			System.out.println("lista" + usuarios.size());
			GenericEntity<List<Usuario>> entity = new GenericEntity<List<Usuario>>(Lists.newArrayList(usuarios)) {
			};
			return Response.status(200).entity(entity).build();
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
	}*/

}