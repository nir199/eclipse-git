package patest.test1;

public class Position {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
//		System.out.println("交换前：a=" + a + "，b=" + b);
//		a = a ^ b;
//		b = a ^ b;
//		a = b ^ a;
//		System.out.println("交换后：a=" + a + "，b=" + b);
		new Position().swap(100, 200);
	}
	
	public void swap(int a, int b) {
		System.out.println("交换前：a=" + a + "，b=" + b);
		a = a ^ b;
		b = a ^ b;
		a = b ^ a;
		System.out.println("交换后：a=" + a + "，b=" + b);
	}
}
