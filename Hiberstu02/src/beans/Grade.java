package beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Grade implements Serializable{
	
	private int gid;
	private String gname;
	private String gdesc;
	//在一方定义一个多方集合
	private Set<Students> stus=new HashSet<Students>();
	
	public Grade() {
		// TODO Auto-generated constructor stub
	}

	public Grade(int gid, String gname, String gdesc, Set<Students> stus) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gdesc = gdesc;
		this.stus = stus;
	}
	
	public Grade(String gname, String gdesc, Set<Students> stus) {
		super();
		this.gname = gname;
		this.gdesc = gdesc;
		this.stus = stus;
	}
	public Grade(String gname, String gdesc) {
		super();
		this.gname = gname;
		this.gdesc = gdesc;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGdesc() {
		return gdesc;
	}

	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}

	public Set<Students> getStus() {
		return stus;
	}

	public void setStus(Set<Students> stus) {
		this.stus = stus;
	}
	
	

}
