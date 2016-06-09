/*package br.com.cadastro.test;

import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import br.com.cadastro.model.Usuario;
import br.com.cadastro.rest.UsuarioRest;

public class UsuarioRestTest  extends JerseyTest{

	@Override
	protected Application configure() {
		return new ResourceConfig(UsuarioRest.class);
	}


	@Test
	public void testAllCartridges() throws URISyntaxException {
		//Client client=ClientBuilder.newClient();
		//WebTarget target=client.target("http://localhost:8080/cadastro-rest/rest/usuario");
		Response response=target.request(MediaType.APPLICATION_JSON).get(Response.class);
		//List<Usuario> carts = response.readEntity(new GenericType<List<Usuario>>() {});
		Assert.assertEquals(response.getStatus(), 200);
		//Assert.assertTrue("A lista deve ter ao menos 1 registro", carts.size() > 0);
	}

}
*/