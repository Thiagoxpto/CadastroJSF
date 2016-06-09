package com.br.cadastro.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import com.br.cadastro.util.WebUtils;


@ManagedBean(name = "usuarioManagedBean")
@ViewScoped
public class UsuarioManagedBean implements Serializable{

	private static final long serialVersionUID = 4333383068210387701L;
	private Client client = ClientBuilder.newClient();
	
	public String envia() {
		System.out.println("INICIO");
		WebTarget webResource = client.target("http://localhost:8080/cadastro-rest/rest/usuario"); 
				//this.client.target(WebUtils.getURLRest("usuario"));
		 Invocation.Builder invocationBuilder = webResource.request(MediaType.APPLICATION_JSON);
		 Response response = invocationBuilder.get();
		System.out.println("Status: "+response.getStatus());
        if (response.getStatus() == 200) {
        	/*Usuario user = response.readEntity(Usuario.class);
            String output = user.getNomeUsuario();
            try {
                JSONArray json = new JSONArray(output);
                List<String> exceptions = Arrays.asList("H", "U", "T", "W");
                for (int i = 0; !json.isNull(i); i++) {
                    JSONObject o = json.getJSONObject(i);
                    if (!exceptions.contains(o.getString("key").toUpperCase())) {
                        //this.listStatus.add(new StatusItem(o.getString("key"), o.getString("value")));
                    }
                }
            } catch (JSONException e) {
                //WebUtils.addMsgError("error.reading.response.from.the.rest.service");
            }*/
        }
		return null;
	}
}
