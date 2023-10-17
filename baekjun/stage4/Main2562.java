package stage4;

import java.util.Scanner;

public class Main2562 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int max = 0;
		int num = 0;
		
		for(int i = 0; i < 9 ; i++) {
			
			arr[i] = sc.nextInt();
			if(arr[i] > max) {
				max = arr[i];
				num = i;
			}
		}
		System.out.println(max);
		System.out.println(num + 1);
		
	}

}
