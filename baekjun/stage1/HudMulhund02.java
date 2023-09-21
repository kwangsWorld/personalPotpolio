package stage1;

import java.util.Scanner;

public class HudMulhund02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N1 = sc.nextInt();
		String S1 = sc.next();
		
		sc.close();
		
		System.out.println(N1 * (S1.charAt(2) - '0')); //- charAt를 이용하여 하나씩 꺼낼때 반드시 - '0' 해야함
		System.out.println(N1 * (S1.charAt(1) - '0'));
		System.out.println(N1 * (S1.charAt(0) - '0'));
		System.out.println(N1 * Integer.parseInt(S1));
	}

}
