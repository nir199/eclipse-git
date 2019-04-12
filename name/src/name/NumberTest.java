package name;

import java.util.Date;


public class NumberTest {
	
	public static void main(String[] args) {
//		long start = new Date().getTime();
//		for(int i = 10000; i < 100000; i++) {
//			int ge = i%10;
//			int shi = i/10%10;
//			int bai = i/100%10;
//			int qian = i/1000%10;
//			int wan = i/10000%10;
//			if(ge == wan && shi == qian && 2*(ge +shi) == bai) {
//				System.out.print(i + "  ");
//			}
//		}
//		long end = new Date().getTime();
//		System.out.println(end - start);
//		for(int i = 1; i < 10; i++) {
//			for(int j = 0; j < 10; j++) {
//				if(2*(i + j) < 10) {
//					System.out.print(10000*i + 1000*j + 100*2*(i + j) + 10*j + i + "  ");
//				}
//			}
//		}
//		long end2 = new Date().getTime();
//		System.out.println(end2 - end );
//		int count = 1;
//		for(int i = 0; i < 6; i++) {
//			for(int j = 0; j <= i; j++) {
//				System.out.print(count++ + "\t");
//			}
//			System.out.println();
//		}
		System.out.println(8>>3);
	}
}

interface A {
	void aMethod();
	interface B {
		void bMethod();
	}
}

class C implements A {

	@Override
	public void aMethod() {
		// TODO Auto-generated method stub
		new B() {

			@Override
			public void bMethod() {
				// TODO Auto-generated method stub
				
			}			
		};
	}	
}

class D {
	void dMethod() {
		new A.B() {
			
			@Override
			public void bMethod() {
				// TODO Auto-generated method stub
				
			}
		};
	}


	public void bMethod() {
		// TODO Auto-generated method stub
		
	}
}