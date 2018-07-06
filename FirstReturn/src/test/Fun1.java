package test;

class Te{
 int nom=0;
 
 public void setnom(int b) {
	 this.nom=b;
 }
 public int getnom() {
	 return this.nom;
 }
}

public class Fun1 {

	public static void main(String[] args) {
		int i=11;
		System.out.println(i);
		changeint(i);
		System.out.println(i);
		
/*		Te te=new Te();
		te.setnom(8);
		System.out.println(te.getnom());
		
		chate(te);
		System.out.println(te.getnom());*/
	}
	
	public static void changeint(int i) {
		i=12;
	}
	
	public static void chate(Te t) {
		t.setnom(999);
	}
}
