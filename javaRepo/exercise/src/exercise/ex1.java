package exercise;

import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {
		
		String str = "aBcDeFg";
		
		int cnt = str.length();
		
		for(int i = 0; i < cnt; i++) {
			if(str.charAt(i)>= 65 && str.charAt(i) <= 90) {
				System.out.println("k");
			}
		}
		
		
		
		
	}

}
