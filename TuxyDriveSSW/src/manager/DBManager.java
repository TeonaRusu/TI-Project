package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import data.UserLogin;
import data.File;

import data.User;

public class DBManager {
	private static final String URL = "jdbc:mysql://localhost:3306/tuxydrive";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final DBManager instance = new DBManager();
	
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	
	public static DBManager getInstance() {
		return instance;
	}
	
	private DBManager() {
		System.out.println("Loading driver...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"Cannot find the driver in the classpath!", e);
		}
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			st = conn.createStatement();
			System.out.println("Connection established...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
public ArrayList<UserLogin> getUserList() {
		
		ArrayList<UserLogin> userList = new ArrayList<UserLogin>();
		try {
			st.execute("select * from user_login");
			System.out.println("saaaluuuut");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			rs = st.getResultSet();
			System.out.println("saaaluuuut2");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				int id = rs.getInt("UserID");
				String  username = rs.getString("Username");
				String  pass = rs.getString("Password");
				System.out.println(id + " " + username + " " + pass);
				UserLogin user = new UserLogin(id,username,pass);
				
		//		System.out.println(user.getId() + " " + user.getPswd() + " " + user.getUsername());
				userList.add(user);
				
			}
			System.out.println("saaaluuuut3");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// st.close();
		return userList;
	
}
	public ArrayList<File> getFileList() {
	
			ArrayList<File> fileList = new ArrayList<File>();
			try {
				st.execute("select * from files");
				System.out.println("select * from files");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				rs = st.getResultSet();
				System.out.println("saaaluuuut2");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				while (rs.next()) {
					int fileID = rs.getInt("FileID");
					int userID = rs.getInt("UserID");
					String  name = rs.getString("Name");
					String  type = rs.getString("Type");
					int size = rs.getInt("Size");
					System.out.println(fileID + " " + userID + " " + name + " " + type + " " + size);
					File file = new File(fileID,userID, name, type, size);
					
			//		System.out.println(user.getId() + " " + user.getPswd() + " " + user.getUsername());
					fileList.add(file);
					
				}
				System.out.println("saaaluuuut3");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// st.close();
			return fileList;
		
	}
	public boolean isUserInUsersTable(String email) {
		try{
			String query = "select * from users";
			rs = st.executeQuery(query);
			while(rs.next()) {
				String dbEmail = rs.getString("email");
				if(email.equals(dbEmail)) {
					return true;
				}
			}
		}catch (Exception ex){
			System.out.println(ex);
		}
		return false;
	}
	public boolean isUserInUser_LoginTable(String username) {
		try{
			String query = "select * from user_login";
			rs = st.executeQuery(query);
			while(rs.next()) {
				String dbUsername = rs.getString("Username");
				if(username.equals(dbUsername)) {
					return true;
				}
			}
		}catch (Exception ex){
			System.out.println(ex);
		}
		return false;
	}
	public boolean isFileInDatabase(String name) {
		try{
			String query = "select * from files";
			rs = st.executeQuery(query);
			while(rs.next()) {
				String dbName= rs.getString("Name");
				if(name.equals(dbName)) {
					return true;
				}
			}
		}catch (Exception ex){
			System.out.println(ex);
		}
		return false;
	}
	public boolean insertUser(User user) {
		try{
			if(isUserInUsersTable(user.getEmail())) {
				return false;
			}
			System.out.println("Am inserat in DB0.");
			String sql = "INSERT INTO users(UserID, LastName, FirstName, Age, Email) VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getUserID());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getFirstName());
			pstmt.setInt(4, (user.getAge()));
			pstmt.setString(5, user.getEmail());
			
			pstmt.executeUpdate();
			System.out.println("Am inserat in DB1.");

		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			if(isUserInUser_LoginTable(user.getUsername())) {
				return false;
			}
			
			ResultSet rs;
			String id = "SELECT LAST_INSERT_ID() last_user" ;
			//Statement st = conn.createStatement();
			rs = st.executeQuery(id);
			while(rs.next()) {
				int userId = Integer.parseInt(rs.getString("last_user"));
				
				String sql2 = "INSERT INTO user_login(UserID, Username, Password) VALUES(?,?,?)";
				PreparedStatement p = conn.prepareStatement(sql2);
				
				p.setInt(1, userId);
				p.setString(2, user.getUsername());
				p.setString(3, user.getPassword());
			
				p.executeUpdate();
				System.out.println("Am inserat in DB2.");
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public boolean insertFile(File file) {
		try{
			if(isFileInDatabase(file.getName())) {
				return false;
			}
			String sql = "INSERT INTO files(FileID, UserID, Name, Type, Email) VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, file.getFileID());
			pstmt.setInt(2, file.getUserID());
			pstmt.setString(3, file.getName());
			pstmt.setString(4, file.getType());
			pstmt.setDouble(5, (file.getSize()));
//			pstmt.setString(6, user.getAddress2());
			pstmt.executeUpdate();
			return true;

		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean checkUserDB (UserLogin user)
	{
		System.out.println("checkUserDB Fct");
		try{
			String query = "select * from user_login";
			rs = st.executeQuery(query);
			System.out.println("saaaluuuut4");
			while(rs.next()) {
				String dbUsername = rs.getString("username");
				String dbPassword = rs.getString("password");
				if(user.getUsername().equals(dbUsername) && user.getPswd().equals(dbPassword)) {
					System.out.println("user + pswd ok");
					return true;
				}
			}
		}catch (Exception ex){
			System.out.println(ex);
		}
		return false;
	}
	
	public UserLogin getUserLogin(String username)
	{
		System.out.println("getUserLogin Fct");
		System.out.println(username);
		try {
			rs = st.executeQuery("select * from user_login where Username = '" + username + "'");
			System.out.println("rs");
			while(rs.next())
			{
				System.out.println("while");
				UserLogin user = new UserLogin(rs.getInt("UserID"),rs.getString("Username"),rs.getString("Password") );
			
//				user.setId(rs.getInt("id"));
//				user.setUsername(rs.getString("username"));
//				user.setPassword(rs.getString("pswd"));
				System.out.println("user login DB " + user);
				return user;
			}
			return null;
		}catch(Exception ex)
		{
			System.out.println(ex);
			return null;
		}
	}
	public User getUser(String email)
	{
		System.out.println("getUserFct");
		System.out.println(email);
		try {
			rs = st.executeQuery("select * from users where Email = '" + email + "'");
			System.out.println("rs");
			while(rs.next())
			{
				System.out.println("while");
				User user = new User(rs.getInt("UserID"),rs.getString("LastName"),rs.getString("FirstName"),rs.getString("Email"),rs.getInt("Size") );
			
//				user.setId(rs.getInt("id"));
//				user.setUsername(rs.getString("username"));
//				user.setPassword(rs.getString("pswd"));
				System.out.println("user DB " + user);
				return user;
			}
			return null;
		}catch(Exception ex)
		{
			System.out.println(ex);
			return null;
		}
	}
	public File getFile(String name)
	{
		System.out.println("getFile Fct");
		System.out.println(name);
		try {
			rs = st.executeQuery("select * from files where Name = '" + name + "'");
			System.out.println("rs");
			while(rs.next())
			{
				System.out.println("while");
				File file = new File(rs.getInt("FileID"),rs.getInt("LastName"),rs.getString("Name"),rs.getString("Type"),rs.getInt("Size") );
			
//				user.setId(rs.getInt("id"));
//				user.setUsername(rs.getString("username"));
//				user.setPassword(rs.getString("pswd"));
				System.out.println("file DB " + file);
				return file;
			}
			return null;
		}catch(Exception ex)
		{
			System.out.println(ex);
			return null;
		}
	}
}