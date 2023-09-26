package stage2;

import java.util.Scanner;
public class LeapYear {

	public static void main(String[] args) {
		int year;
		
		Scanner sc = new Scanner(System.in);
		
		year = sc.nextInt();
				
		if(year % 4 ==0) {
			if(year % 100 != 0 || year % 400 == 0) {
			System.out.println(1);
			}
			else {
				System.out.println(0);
			}
		}
		else {
			System.out.println(0);
		}
	}
}