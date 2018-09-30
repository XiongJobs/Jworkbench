package bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Article {
	private int id;
	private int pid;
	private int rotid;
	private int grade;
	private String title;
	private String cont;
	private Date pdate;
	private boolean isleaf;
	
	
	public void initFromRs(ResultSet res) {
		try {
			this.setId(res.getInt("id"));
			this.setPid(res.getInt("pid"));
			this.setRotid(res.getInt("rootid"));
			this.setTitle(res.getString("title"));
			this.setIsleaf(res.getInt("isleaf")==0 ? true:false);
			this.setPdate(res.getTimestamp("pdate"));
			this.setCont(res.getString("cont"));
			this.setGrade(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getRotid() {
		return rotid;
	}
	public void setRotid(int rotid) {
		this.rotid = rotid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public boolean isIsleaf() {
		return isleaf;
	}
	public void setIsleaf(boolean isleaf) {
		this.isleaf = isleaf;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	
}
