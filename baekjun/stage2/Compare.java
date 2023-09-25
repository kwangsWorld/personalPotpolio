package stage2;

import java.util.Scanner;
public class Compare {

	public static void main(String[] args) {
		
		int num1, num2;
		
		Scanner sc = new Scanner(System.in);
		
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		if(num1 > num2) {
			System.out.println(">");
		}
		else if(num1 < num2) {
			System.out.println("<");
		}
		else {
			System.out.println("==");
		}
	}
}
