package data;

public class Files {
	private int fileID;
	private int userID;
	private String name;
	private String type;
	private int size;

	public Files(){
		this.userID = 0;
		this.fileID = 0;
		this.name = null;
		this.type = null;
		this.size = 0;
		
	}

	public Files(int userID, int fileID, String name, String type, int size) {
		this.userID = userID;
		this.fileID = fileID;
		this.name = name;
		this.type = type;
		this.size = size;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public String getName() {
		return name;
	}
	
	public int getFileID() {
		return fileID;
	}
	
	public String getType() {
		return type;
	}
	public int getSize() {
		return size;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public void setName(String Name) {
		this.name = Name;
	}
	public void setFileID(int fileID) {
		this.fileID = fileID;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
