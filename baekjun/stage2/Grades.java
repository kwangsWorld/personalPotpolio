package stage2;

import java.util.Scanner;
public class Grades {

	public static void main(String[] args) {
		int point;
		
		Scanner sc = new Scanner(System.in);
		
		point = sc.nextInt();
		
		if(point>=90) {
			System.out.println('A');
		}
		else if(point>=80) {
			System.out.println('B');
		}
		else if(point>=70) {
			System.out.println('C');
		}
		else if(point>=60) {
			System.out.println('D');
		}
		else {
			System.out.println('F');
		}
	}

}
