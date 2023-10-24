package stage4;

import java.util.Scanner;

public class Main10818 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;
		int min = 0;
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		max = arr[0];
		min = arr[0];
		
		for(int i = 1; i < n; i++) {
			if(max < arr[i]) {max = arr[i];}
			if(min > arr[i]) {min = arr[i];}
		}
		System.out.println(min + " " + max);
	}

}
