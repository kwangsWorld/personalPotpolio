package stage3;

import java.util.Scanner;

public class Main11021 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			sum = num1 + num2;
			System.out.println("Case #" + (i+1) + ": " + sum);
		}
	}

}
