package stage4;

import java.util.Scanner;

public class Main1546 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		double maxNum = 0;
		int num = sc.nextInt();
		double[] arr = new double[num];
		double sum = 0;
		double avg = 0;
		
		//입력받기
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextDouble();
//			System.out.println("arr[" + i + "] = " +arr[i]);
		}
		
		//최대값 구하기
		for(int i = 0; i < arr.length; i++) {
			if(num == 1) {		//숫자가 하나일경우 그 숫자가 최대값
				maxNum = arr[i];
				break;
				}
			if(i == arr.length -1) {break;} //ArrIndexOut 대비
			if(arr[i] < arr[i+1]) {
				maxNum = arr[i+1];
			}
			else {maxNum = arr[i];}
		}
//		System.out.println("maxNum : " + maxNum);
		//성적 조작
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (arr[i] / maxNum) * 100;
			sum += arr[i];
//			System.out.println("arr[" + i + "] = " +arr[i]);
		}
		//평균 구하기
		avg = sum / (double)arr.length;
		System.out.println(avg);
	}

}
