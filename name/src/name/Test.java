package name;

import java.util.Collections;

public class Test {
	
	public static void main(String[] args) {
//		Su su = new Th();
//		su.show();
//		Integer a = new Integer(2);
//		Integer b = 2;
//		Integer c = 2;
//		int d = 2;
//		System.out.println("a==b:" + (a==b));
//		System.out.println("a==c:" + (a==c));
//		System.out.println("a==d:" + (a==d));
//		System.out.println("b==c:" + (b==c));
//		print((char)97);
		try {
			System.out.println("**********try start**********");
			int i = 1/0;
			System.out.println("**********try end************");
		} catch (ArithmeticException e) {
			System.out.println("**********catch start********");
			int i = 1/0;
			System.out.println("**********catch end**********");
		} catch (Exception e) {
			System.out.println("**********exception catch****");
		} finally {
			System.out.println("**********finally block******");
		}
	}
	public static void print(byte b){
		System.out.println("arg is byte:" + b);
	}
	public static void print(short s){
		System.out.println("arg is short:" + s);
	}
	public static void print(int i){
		System.out.println("arg is int:" + i);
	}
	public static void print(char c){
		System.out.println("arg is char:" + c);
	}
	public static void print(long l){
		System.out.println("arg is long:" + l);
	}
}

class Su {
	public void show() {
		System.out.println("这是Su");
	}
}

class Th extends Su {
	public void show() {
		System.out.println("这是Th");
		//return "";
	}
}