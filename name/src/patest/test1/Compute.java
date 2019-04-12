package patest.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Compute {
	public static void main(String args[]){
			//Scanner scanner = new Scanner(System.in);
			//int num = Integer.parseInt(scanner.nextLine());
			//scanner.close();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int num = 0;
			try {
				num = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(ability(num));
	}
	public static int ability(int num){
		int i = 0;
		while(true){
			if(num == 1){
				break;
			}
			if(num%2 == 0){
				i++;
				num/=2;
			}else{
				i++;
				num=3*num+1;
			}
		}
		return i;
	}
}
