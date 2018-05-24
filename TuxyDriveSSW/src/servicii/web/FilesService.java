package servicii.web;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import manager.DBManager;
import data.File;
import data.UserLogin;

@Path("/file")
public class FilesService{
	@GET
	@Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public ArrayList<File> getProducts(@PathParam("id") int id) {
        System.out.println("Get List with Files");
        return DBManager.getInstance().getFileList(id);  
    }
}