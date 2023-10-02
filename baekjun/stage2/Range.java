package stage2;

import java.util.Scanner;

public class Range {

	public boolean rangeLimit(int num, int min, int max) {
		
		if(num >= min && num <= max) {
			return true;
		}
		else {
			System.out.println("범위는 " + min + "부터 " + max + "까지 입니다. 다시 입력해주세요");
			return false;
		}
	}	
}
