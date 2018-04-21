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
			System.out.println("Connection enstablished...");
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				rs = st.getResultSet();
				System.out.println("saaaluuuut2");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				
				while (rs.next()) {
					int id=rs.getInt("id");
					String  username=rs.getString("username");
					String  pass=rs.getString("password");
					System.out.println(id+" "+username+ " "+pass);
					UserLogin user = new UserLogin(id,username,pass);
					
					System.out.println(user.getID()+" "+user.getPswd()+ " "+user.getUsername());
					userList.add(user);
					
				}
				System.out.println("saaaluuuut3");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// st.close();
			return userList;
		
	}
	public boolean checkUserDB (String username,String password)
	{
		try{
			String query = "select * from user_login";
			rs = st.executeQuery(query);
			System.out.println("saaaluuuut4");
			while(rs.next()) {
				String dbUsername = rs.getString("username");
				String dbPassword = rs.getString("password");
				if(username.equals(dbUsername) && password.equals(dbPassword)) {
					return true;
				}
			}
		}catch (Exception ex){
			System.out.println(ex);
			
		}
		return false;
	}
	
}