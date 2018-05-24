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

import data.UserLogin;
import data.UserParser;

import org.json.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:1234/TuxyDriveSSW/").build();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		
		String user = request.getParameter("username");
		String pswd = request.getParameter("pswd");
		String password = "";
		System.out.println("user-->" + user);
		
		if (!user.equals(null) && !user.equals("")) {
			if(!pswd.equals(null) && !pswd.equals("") ) {
			
				ClientConfig config = new ClientConfig();
				Client client = ClientBuilder.newClient(config);
				client.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
				WebTarget service = client.target(getBaseURI());
				Response resp;
				
				UserLogin user2 = new UserLogin(0, user, pswd);
				user2.setUsername(user);
				user2.setPassword(pswd);
				
				/*Check if user in in database */
				resp = service.path("rest").path("login").request().post(Entity.entity(user2, MediaType.APPLICATION_JSON), Response.class);
				String value = resp.readEntity(String.class);
				
				if(value.equals("false")) {
					HttpSession session = request.getSession();
					session.setAttribute("error-msg", "User in not in database!");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}else {
					
					/*Creare sesiune cu datele utilizatorului*/
					resp = service.path("rest").path("login").path(user).request().accept(MediaType.APPLICATION_JSON).get(Response.class);
					String data = resp.readEntity(String.class);
					int status = resp.getStatus();
					System.out.println(data);
	
					if (status == 200){
						// JSON Parser		
						try {
							JSONObject obj = new JSONObject(data);
							password =  obj.getString("pswd");
							System.out.println("Parola este:" + password);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						HttpSession session = request.getSession();
						if (password.equals(pswd)) {
							
							System.out.println("Correct password!");
							session.setAttribute("success-msg", "Login Successfully!");
							session.setAttribute("username", user2.getUsername());
							session.setAttribute("id", user2.getId());
							session.setAttribute("pass", user2.getPswd());
							
							response.sendRedirect("home.jsp");
						}else{
							System.out.println("Incorrect password!");
							session.setAttribute("error-msg", "Incorrect password!");
							response.sendRedirect("login.jsp");
						}
					}else{
							
						request.setAttribute("msg", "User isn't in database!");
						response.sendRedirect("login.jsp");
					}
				}
				}else{
					request.setAttribute("msg", "Password is mandatory!");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("msg", "Fields are mandatory!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
	}
}
