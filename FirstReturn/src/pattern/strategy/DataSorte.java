package pattern.strategy;

public class DataSorte {
	public DataSorte(){
		
	}
	
	public static void sort(int[] a) {
		int temp;
		for(int i=a.length;i>0;i--) {
			for(int j=0;j<i-1;j++ ) {
				if(a[j]>a[j+1]) {
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
	}
	
	public static void print(int[] a) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}
