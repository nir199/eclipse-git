package recursion;

public class Hannuota {
	public static void main(String args[]){
		move(4, 'X', 'Y', 'Z');
	}
	public static void move(int n, char x, char y, char z){
		if(1 == n){
			System.out.println(x+"--->"+z);
		}else {
			move(n-1, x, z, y);
			System.out.println(x+"--->"+z);
			move(n-1, y, x, z);
		}
	}
}
