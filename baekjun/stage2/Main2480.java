package stage2;

import java.util.Scanner;

public class Main2480 {

	public static void main(String[] args) {  // a b c  a,b b,c 
		
		//주사위 입력받기
		//상금 조건 
		//상금 출력
		
		Scanner sc = new Scanner(System.in);
		
		int firstDice = sc.nextInt();
		int secondDice = sc.nextInt();
		int thirdDice = sc.nextInt();
		
		int reward = 0;
		int max = 0;
		
		if(firstDice >= secondDice) {       // A vs B   1)A -- B vs C -- 11)B 22)C  
			if(firstDice >= thirdDice) {
			max = firstDice;
			}else {
				max = thirdDice;
			}
		}
		else {
			if(secondDice >= thirdDice) {
				max = secondDice;
			}
			else {
				max = thirdDice;
			}
		}
		
		if(firstDice == secondDice && firstDice == thirdDice) {
			reward = 10000 + firstDice*1000;
		}else if(firstDice == secondDice || firstDice == thirdDice 
				|| secondDice == thirdDice) {
			if(firstDice == secondDice) {
				reward = 1000 + firstDice*100;
			}else if(firstDice == thirdDice) {
				reward = 1000 + firstDice*100;
			}else if(thirdDice == secondDice) {
				reward = 1000 + thirdDice*100;
			}
		}else {
			reward = max * 100;	
		}
		
		System.out.println(reward);
		
	} //main

} //class
