package servicii.web;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import manager.DBManager;
import data.User;

@Path("/register")
public class RegisterService {
	@POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response postUser(@Context UriInfo uriInfo, User user) {
        System.out.println("RegisterService -- Post");
        Response response;
        if (DBManager.getInstance().insertUser(user)) {
            response = Response.created(uriInfo.getRequestUriBuilder().path(user.getEmail()).build()).entity(user).build();
        } else {
            response = Response.seeOther(uriInfo.getRequestUriBuilder().path(user.getEmail()).build()).build();
        }
        return response;
    }
}
