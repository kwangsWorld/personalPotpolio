package stage1;

import java.util.Scanner;
public class HudMulhund01 {

	public static void main(String[] args) {
		int num1, num2;
		
		Scanner sc = new Scanner(System.in);
		
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		int num2hund = num2/100;
		int num2ten = (num2-(num2hund*100))/10;
		int num2one = (num2-(num2hund*100)-(num2ten*10));
		
		int result1 = num1 * num2one;
		int result2 = num1 * num2ten;
		int result3 = num1 * num2hund;
		int result4 = result1 + result2 * 10 + result3 * 100;
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
			
	}
}
