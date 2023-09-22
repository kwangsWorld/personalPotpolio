package stage1;

import java.util.Scanner;

public class ScannerYear {

	public static void main(String[] args) {
		
		int y;
		
		Scanner sc = new Scanner(System.in);
		
		y = sc.nextInt();
		
		if( y >= 1000 && y <= 3000) {
			System.out.println(y - 543);
		}	
	}
}
