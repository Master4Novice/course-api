package io.abhi.data;

public class User {
    private String name;
	private String username;
    private String password;
    private String emailId;
    private long contactNumber;
    
    public User(){
    	
    }
    
    public User(String name, String username, String password, String emailId, long contactNumber) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
	}
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
}
