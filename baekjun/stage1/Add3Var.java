package stage1;

import java.util.Scanner;
public class Add3Var {

	public static void main(String[] args) {
		
		long num1, num2, num3;
		
		Scanner sc = new Scanner(System.in);
		
		num1 = sc.nextLong();
		num2 = sc.nextLong();
		num3 = sc.nextLong();
		
		long sum = num1+num2+num3;
		
		System.out.println(sum);
	}

}
