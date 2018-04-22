package servicii.web;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import manager.DBManager;
import data.UserLogin;

@Path("/login")
public class LoginService {
	@POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String postUserStatus(@Context UriInfo uriInfo, UserLogin user) {
        System.out.println("LoginService -- Post");
        if (DBManager.getInstance().checkUserDB(user)) {
            return "true";
        } else {
            return "false";
        }
	}
	
	@GET
	@Path("{username}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public UserLogin getUser(@PathParam("username") String username) {
		System.out.println("LoginService -- Get");
		return DBManager.getInstance().getUserLogin(username);
	}
}


