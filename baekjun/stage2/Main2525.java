package stage2;

import java.util.Scanner;

public class Main2525 {

	public static void main(String[] args) {
		
		//현재시간 입력받기(현재시간 조건 충족)
		//조리시간 입력받기(조리시간 조건 충족)
		//현재시간 + 조리시간  (23시 59분 check)
		//결과 출력
		
		Range r = new Range();
		
		Scanner sc = new Scanner(System.in);
		
		int hour = 0;
		boolean isFinish = false;
		
		while(!isFinish) {
			System.out.print("현재 시간을 입력하시오 : ");
			hour = sc.nextInt();
			isFinish = r.rangeLimit(hour, 0, 23);	
		}
		
		int minute = 0;
		isFinish = false;
		
		while(!isFinish) {
			System.out.print("현재 분을 입력하시오 : ");
			minute = sc.nextInt();
			isFinish = r.rangeLimit(minute, 0, 60);
		}
		
		int cookMinute = 0;
		isFinish = false;
		
		while(!isFinish) {
			System.out.print("조리 시간을 입력하시오 : ");
			cookMinute = sc.nextInt();
			isFinish = r.rangeLimit(cookMinute, 0, 1000);
		}
		
		int finishMinute = minute + cookMinute;
		if(finishMinute >= 120) {
			hour += 2;
			finishMinute -= 120;
		}
		else if(finishMinute >= 60) {
			hour += 1;
			finishMinute -= 60;
		}
		else {
			finishMinute += 0;
			hour += 0;
		}
		if(hour >=24) {
			hour -= 24;
		}
		
		System.out.println("요리가 완성되는 시간은 " + hour + "시 " + finishMinute + "분 입니다.");
		

	} //main
	
}//class
