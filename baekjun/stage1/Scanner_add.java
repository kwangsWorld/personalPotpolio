
package stage1;

import java.util.Scanner;

public class Scanner_add {
	
	public static void main(String[] args) {
		int num1, num2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 숫자를 입력하시오");
		num1 = sc.nextInt();
		System.out.println("두번째 숫자를 입력하시오");
		num2 = sc.nextInt();
		
		System.out.println("두 수의 합은 " + (num1+num2) + "입니다.");
	}

}
