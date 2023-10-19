package stage4;

import java.util.Scanner;

public class Main5597 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[31];
		
		for(int i = 0; i < 28; i++) {
			int num = sc.nextInt();
			arr[num] = 1;
		}
		
		for(int i = 1; i <=30; i++) {
			if(arr[i] != 1) {
				System.out.println(i);
			}
		}
	}

}
