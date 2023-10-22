package stage4;

import java.util.Scanner;

public class Main10811 {
	/* N = 5, M = 4
	5개 바구니, 4번 바꾸기(2번 입력받기)
	1 2 3 4 5  // 1 2
	2 1 3 4 5  // 3 4
	2 1 4 3 5  // 1 4
	3 4 1 2 5  // 2 2
	*/
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt() ;
		int m = sc.nextInt() ;
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = i+1;
		}
		
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt() -1;
			int y = sc.nextInt() -1;
			while(x < y) {
				int temp = arr[x];
				arr[x++] = arr[y];
				arr[y--] = temp;
			}
		}
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i]+ " ");
		}
		
	}//main
	
}//class




