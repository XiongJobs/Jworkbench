package beans;

public class Adress {
	
	private String postcode;
	private String phone;
	private String address;
	
	public Adress() {
		// TODO Auto-generated constructor stub
	}

	public Adress(String postcode, String phone, String address) {
		super();
		this.postcode = postcode;
		this.phone = phone;
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Adress [postcode=" + postcode + ", phone=" + phone + ", address=" + address + "]";
	}
	
	
}
