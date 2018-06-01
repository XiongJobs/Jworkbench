package test;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,4,6,8,9,3};
		printarray(a);
		sortarray(a);
	}
	
	
	
	
	public static void sortarray(int[]a) {
		int[] b=a;
		
		for(int i=0;i<b.length;i++) {
			int k=i,temp=0;
			
			for(int j=k+1;j<b.length;j++) {
				if(b[j]<b[k]) {
					k=j;
				}
			}
			temp=b[i];
			b[i]=b[k];
			b[k]=temp;
			
		}
		
		printarray(b);
	}
	
	public static void printarray(int[]a) {
		for(int t:a) {
			System.out.print(t+" ");
		}
		System.out.println();
	}
}
