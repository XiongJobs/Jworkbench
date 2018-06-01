package test;

public class HelloJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Hello JAVA");
		//System.out.println(0xcafe);
		
		int[] one= {1,2,3,4,5};
		int[] two= {6,7,8,9,10,11,12,13,14,15};
		
		for(int i=0;i<one.length;i++) {
			System.out.print(one[i]+"  ");
		}
		System.out.println();
		for(int i=0;i<two.length;i++) {
			System.out.print(two[i]+"  ");
		}
		System.out.println();
		
		System.arraycopy(one, 0, two, 5, one.length);
		
		for(int i=0;i<one.length;i++) {
			System.out.print(one[i]+"  ");
		}
		System.out.println();
		for(int i=0;i<two.length;i++) {
			System.out.print(two[i]+"  ");
		}
		
		Person peo =new Person();
	}
	

	

}
