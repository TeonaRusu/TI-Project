package data;

public class UserLogin {
	private int id;
	private String username;
	private String pswd;

	public UserLogin(){
		this.id = 0;
		this.username = null;
		this.pswd = null;
	}

	public UserLogin(int id, String username, String pswd) {
		this.id = id;
		this.username = username;
		this.pswd = pswd;
	}
	
	public int getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPswd() {
		return pswd;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String pswd) {
		this.pswd = pswd;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id)
			.append(", username=").append(username).append(", password=")
			.append(pswd).append("]");
		return builder.toString();
	}
}
