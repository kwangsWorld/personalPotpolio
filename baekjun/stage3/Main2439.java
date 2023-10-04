package stage3;

import java.util.Scanner;

public class Main2439 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int stage = sc.nextInt();
		int star = 1;
		
		for(int i = 1; i <= stage; i++) {
			for(int j = 1; j <= stage-i; j++) { // 4 3 2 1 0
				System.out.print(" ");
			}
			for(int j = 1; j <= star; j++) {
				System.out.print("*");
			}
			star++;
			System.out.println();
		}
	}

}