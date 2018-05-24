package data;

public class User {
	private int userID;
	private String lastName;
	private String firstName;
	private String email;
	private int age;
	private String username;
	private String password;

	public User(){
		this.userID = 0;
		this.lastName = null;
		this.firstName = null;
		this.email = null;
		this.username = null;
		this.password = null;
		
	}

	public User(String lastName, String firstName, String email, int age, String username, String password) {
		this.userID = 0;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.age = age;
		this.username = username;
		this.password = password;
	}
	public User(int userID, String lastName, String firstName, String email, int age) {
		this.userID = userID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.age = age;
		
	}
	public int getUserID() {
		return userID;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getEmail() {
		return email;
	}
	public int getAge() {
		return age;
	}
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword (String password) {
		this.password = password;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [UserID=").append(userID)
			.append(", LastName=").append(lastName).append(", FirstName=")
			.append(firstName).append(", Email=")
			.append(email).append(", Age=")
			.append(age).append(", Username=")
			.append(username).append(", Password=")
			.append(password).append("]");
		return builder.toString();
	}

}
