package stage1;

import java.util.Scanner;

public class Scanner_sub {

	public static void main(String[] args) {
		
		int num1, num2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("두 수를 입력하시오 :");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		System.out.print("두 수의 차는 " + (num1-num2) + "입니다." );
		
	}

}
