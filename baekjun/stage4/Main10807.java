package stage4;

import java.util.Scanner;

public class Main10807 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		int cnt = 0;
		
		for(int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();	
		}
		int n = sc.nextInt();
		
		for(int i = 0; i < num; i++) {
			if(arr[i] == n) {cnt++;}
		}
		
		System.out.println(cnt);
	}

}
