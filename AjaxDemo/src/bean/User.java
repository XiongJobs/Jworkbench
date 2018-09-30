package bean;

public class User {
	private String id;
	private String pwd;
	
	public User(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	public User() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}	
