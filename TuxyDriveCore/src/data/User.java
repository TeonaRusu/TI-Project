package data;

public class User {
	private int userID;
	private String lastName;
	private String firstName;
	private String email;
	private int age;

	public User(){
		this.userID = 0;
		this.lastName = null;
		this.firstName = null;
		this.email = null;
		
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
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setPassword(String email) {
		this.email = email;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("User [id=").append(id)
//			.append(", username=").append(username).append(", password=")
//			.append(pswd).append("]");
//		return builder.toString();

}
