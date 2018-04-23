package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.UserLogin;

public class DBManager {
	private static final String URL = "jdbc:mysql://localhost:3306/tuxydrive_db";
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
					int id = rs.getInt("id");
					String  username = rs.getString("username");
					String  pass = rs.getString("password");
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
			rs = st.executeQuery("select * from user_login where username = '" + username + "'");
			System.out.println("rs");
			while(rs.next())
			{
				System.out.println("while");
				UserLogin user = new UserLogin(rs.getInt("id"),rs.getString("username"),rs.getString("password") );
			
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
}