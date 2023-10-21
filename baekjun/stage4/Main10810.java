package stage4;

import java.util.Scanner;

public class Main10810 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int cnt = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < cnt; i++) {
			int q = sc.nextInt() - 1;
			int w = sc.nextInt() - 1;
			int e = sc.nextInt();
			
			for(int j = q; j <= w; j++) {
				arr[j] = e;
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
			
		}
		
	}

}
