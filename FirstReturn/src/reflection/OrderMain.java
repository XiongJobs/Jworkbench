package reflection;

public class OrderMain {

	public static void main(String[] args) {
		Order od=new Order();
		od.setProductName("apple");
		od.setCount(10);
		od.setUnitPrice(2);
		System.out.println(od);

	}

}
