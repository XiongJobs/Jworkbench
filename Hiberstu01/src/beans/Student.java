package beans;

import java.util.Date;

public class Student {
	private int sid; //ѧ��
	private String sname; //����
	private String gender; //�Ա�
	private Date birthday; //��������
	//private String address; //��ַ
	private Adress adds;
	
	
	public Student() {
		super();
	}
	
	
	public Student(int sid, String sname, String gender, Date birthday, Adress adds) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.adds = adds;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public Adress getAdds() {
		return adds;
	}


	public void setAdds(Adress adds) {
		this.adds = adds;
	}


	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", gender=" + gender + ", birthday=" + birthday + ", adds="
				+ adds + "]";
	}




	
	
}
