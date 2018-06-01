package reflection;

public class Order {
	private String productName=null;
	private int count=0;
	private int unitPrice=0;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return productName+"-"+getTotalPrice();
		
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public int getTotalPrice() {
		return this.count*this.unitPrice;
	}

}
