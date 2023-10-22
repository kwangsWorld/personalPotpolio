package stage4;

import java.util.Scanner;

public class Main10813 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int cnt = sc.nextInt();
		
		int[] arr = new int[n];
		
		int tempt = 0;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			
		}
		
		for(int i = 0; i < cnt; i++) {
			int q = sc.nextInt() - 1; 
			int w = sc.nextInt() - 1;
			
			tempt = arr[q];
			arr[q] = arr[w];
			arr[w] = tempt;
		}	
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
			
		}
		
	}//main

}//class
