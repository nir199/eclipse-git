package recursion;

import java.util.Scanner;

public class Recursion {
	static int index = 0;
	static Scanner scanner = new Scanner(System.in);
	static char[] c = scanner.next().toCharArray();
	//static char[] c = {'a','b','c','#'}; 
	public static void main(String args[]){
		//Recursion recursion = new Recursion();
		//recursion.pint();
		//System.out.println(recursion.c);
		if(c[c.length-1]!='#'){
			System.out.println("error!!!");
		}else{
			pint();
		}
	}
	public static void pint(){
		char a='a';
		if(index < c.length){
			a = c[index++];
		}
		if('#' != a){
			pint();
		}
		if('#' != a){
			System.out.print(a);
		}
	}
}
