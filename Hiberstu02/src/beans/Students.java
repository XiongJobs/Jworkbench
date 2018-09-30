package beans;

import java.io.Serializable;

public class Students implements Serializable{
	private int sid;
	private String sname;
	private String sex;
	private Grade grade;
	
	public Students() {
		// TODO Auto-generated constructor stub
	}

	public Students(int sid, String sname, String sex) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
	}
	
	public Students(String sname, String sex) {
		super();
		this.sname = sname;
		this.sex = sex;
	}
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	

}
