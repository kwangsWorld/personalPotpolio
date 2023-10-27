package stage4;

import java.util.Scanner;

public class Main10871 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int num = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] < num) {
				System.out.print(arr[i] + " ");
			}
		}
		
	}

}
