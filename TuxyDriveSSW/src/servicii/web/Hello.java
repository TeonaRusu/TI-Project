package servicii.web;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.File;
import manager.DBManager;

// adnotarea Path specifica calea relativa spre un anumit serviciu web
// e.g., @ApplicationPath("rest") + @Path("/hello") => http://localhost:8080/ProiectServiciiWeb/rest/hello
// in aceasta situatie se va apela una din metodele clasei Hello, in functie de tipul media (text/plain, text/xml sau text/html)
@Path("/hello")
public class Hello {

	// Metoda apelata daca tipul media cerut este TEXT_PLAIN
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		ArrayList <File> arrayFiles = DBManager.getInstance().getFileList(1);
		String result = "";
		for (int i = 0; i < arrayFiles.size(); i++) {
			result += arrayFiles.get(i).getName() + "#";
			result += arrayFiles.get(i).getType() + "#";
			result += arrayFiles.get(i).getSize() + "#";
			result += "aici#";
			System.out.println(result);
		}
		return "Hello, TuxyDrive User!#" + result ;
	}

	// Metoda apelata daca tipul media cerut este XML
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		ArrayList <File> arrayFiles = DBManager.getInstance().getFileList(1);
		String result = "";
		for (int i = 0; i < arrayFiles.size(); i++) {
			result += arrayFiles.get(i).getName() + "#";
			result += arrayFiles.get(i).getType() + "#";
			result += arrayFiles.get(i).getSize() + "#";
			result += "aici#";
			System.out.println(result);
		}
		return "Hello, TuxyDrive User!#" + result ;
		
	}

	// Metoda apelata daca tipul media cerut este HTML
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		ArrayList <File> arrayFiles = DBManager.getInstance().getFileList(1);
		String result = "";
		for (int i = 0; i < arrayFiles.size(); i++) {
			result += arrayFiles.get(i).getName() + "#";
			result += arrayFiles.get(i).getType() + "#";
			result += arrayFiles.get(i).getSize() + "#";
			result += "aici#";
			System.out.println(result);
		}
		return "Hello, TuxyDrive User!#" + result ;
	}

}
