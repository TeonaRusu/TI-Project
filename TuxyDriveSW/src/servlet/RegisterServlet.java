package servlet;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;

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

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.HttpUrlConnectorProvider;

import data.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:1234/TuxyDriveSSW/").build();
    }
	
	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("RegisterServlet");
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String user = request.getParameter("username");
		String age = request.getParameter("age");
		int age2 = Integer.parseInt(age);
		String email = request.getParameter("email");
		String pswd1 = request.getParameter("pswd1");
		String pswd2 = request.getParameter("pswd2");
		
		System.out.println("fname: " + fname);
		
		if ((pswd1.equals(null) && pswd1.equals("")) || pswd2.equals(null) && pswd2.equals("")){
			
			request.setAttribute("register-msg", "Pasword is mandatory!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		
		if(!pswd1.equals(pswd2))
		{
			request.setAttribute("register-msg", "Paswords don't match!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		if (!fname.equals(null) && !fname.equals("") && !lname.equals(null) && !lname.equals("") 
				&& !user.equals(null) && !user.equals("") && !email.equals(null) && !email.equals("")){
			
			/* Creare obiect RegisterUser */
			System.out.println("Crapa inainte de constructor.");
			User Ruser = new User(lname, fname, email, age2, user, pswd1);
			System.out.println("Crapa la constructor.");
			Ruser.setFirstName(fname);
			Ruser.setLastName(lname);
			Ruser.setAge(age2);
			Ruser.setEmail(email);
			Ruser.setPassword(pswd1);
			

			ClientConfig config = new ClientConfig();
	        Client client = ClientBuilder.newClient(config); 
	        client.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
			WebTarget service = client.target(getBaseURI());
			Response resp;
			
			resp = service.path("rest").path("register").request(MediaType.APPLICATION_JSON).post(Entity.entity(Ruser, MediaType.APPLICATION_JSON), Response.class);
			System.out.println(resp.getStatus());
			if(resp.getStatus() == 201) {  // accepted -> resursa a fost creata
				System.out.println("Resursa creata");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("msg", "This email already exists!");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "Fields are mandatory!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}
}