package exercise;

public class ex1 {

	public static void main(String[] args) {
		
		String a = "aBcDeFg";
		
		int cnt = a.length();
		
		char[] arr = new char[cnt];
		
		
		for(int i = 0; i < cnt; i++) {
		
			arr[i] = a.charAt(i);
			int num = arr[i];
			if(num >= 65 && num <= 90) {
				num += 32;
			}
			else {
				num -= 32;
			}
			arr[i] = (char)num;
		}
		System.out.println(arr);
	}

}
