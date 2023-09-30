package stage2;

import java.util.Scanner;

public class Main2884 {

	public static void main(String[] args) {
		//알람 시간 받기 (HH:MM)
		//-45분 알고리즘 짜기
		// 1) mm이 10 - 45 = -35 + 60 = 25
		// 2) mm이 음수가되면 hh - 1 & mm + 23
		// 3) hh가 음수면 hh + 23
		// 출력해주기
		
		Scanner sc = new Scanner(System.in);
		
		int hour = 0;
		
		while(true) {
			hour = sc.nextInt();
			if(hour >= 0 && hour <= 23) {
				break;
			}
			else {
				System.out.println("0부터 23까지의 숫자를 입력해주세요");
			}
		}
		
		int minute = 0;
		
		while(true) {
			minute = sc.nextInt();
			if(minute >= 0 && minute <= 60) {
				break;
			}
			else {
				System.out.println("0부터 60까지의 숫자를 입력해주세요");
			}
		}
		
		int awakeMinute = minute - 45;
		
		if(awakeMinute < 0) {
			hour --;
			awakeMinute += 60;
			if(hour < 0 ) {
				hour += 24;
			}
			
		}
		else {
			if(hour < 0 ) {
				hour += 24;
			}
		}
		System.out.println(hour + " " + awakeMinute);
	}
}
