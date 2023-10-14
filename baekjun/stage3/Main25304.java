package stage3;

import java.util.Scanner;

public class Main25304 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int totalBill = sc.nextInt();
		int n = sc.nextInt();
		int price = 0; 
		int cnt = 0;
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			price = sc.nextInt();
			cnt = sc.nextInt();
			sum += price * cnt;
		}
		
		if(sum == totalBill) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
		
		
	}

}
