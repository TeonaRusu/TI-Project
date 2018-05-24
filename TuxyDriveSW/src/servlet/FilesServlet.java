package servlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.HttpUrlConnectorProvider;
//import org.json.JSONException;
//import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import data.File;

@WebServlet("/FilesServlet")
public class FilesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public FilesServlet() {
		super();
	}
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:1234/TuxyDriveSSW/").build();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Get files servlet");
		
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		client.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
		WebTarget service = client.target(getBaseURI());
		
		Response response;
		response = service.path("rest").path("file").path("1").request().accept(MediaType.APPLICATION_JSON).get(Response.class);
		String data = response.readEntity(String.class);
		int status = response.getStatus();

		System.out.println("File List" + data);
		
		if (status == 200){
			
			resp.getWriter().append(data);
			
		}else {
			System.out.println("naspa");
		}
	}
}



