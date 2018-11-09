package web.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Person {
	private String id;
	
	@Size(min=3,max=10,message="用户名必须大于3个字符，小于10个字符")
	private String name;
	@NotNull(message="年龄不能为空")
	private String age;
	private String photopath;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public String getPhotopath() {
		return photopath;
	}

	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", photopath=" + photopath + "]";
	}


	
	
}
