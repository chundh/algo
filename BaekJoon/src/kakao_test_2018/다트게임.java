package kakao_test_2018;

public class 다트게임 {
	static int first_num = 0;
	static int sec_num = 0;
	static int third_num = 0;
	public static void main(String args[]) {
		String dartResult = "1D2S#10S";
		
		solution(dartResult);
	}
	
	public static void solution(String dartResult) {
		int answer = 0;
		String first_str = null;
		String sec_str = null;
		String third_str = null;
		int index=0;
		for(int i=2; i<dartResult.length(); i++) {
			if(dartResult.charAt(i)>= 48 && dartResult.charAt(i)<= 57) {
				if(index == 0)
					first_str = dartResult.substring(index, i);
				else {
					if(dartResult.charAt(i-1)>= 48 && dartResult.charAt(i-1)<= 57)
						continue;
					sec_str = dartResult.substring(index, i); 
				}
				index = i;
			}
		}
		third_str = dartResult.substring(index, dartResult.length());
		System.out.println(first_str + " , " + sec_str + " , " + third_str);
		first_num = calc(0, first_str);
		sec_num = calc(1, sec_str);
		third_num = calc(2, third_str);
		System.out.println(first_num + " , " + sec_num + " , " + third_num);
		answer = first_num + sec_num + third_num;
		System.out.println(answer);
	}
	
	public static int calc(int i, String arr) {
		int num = 0;
		if(arr.charAt(1)>= 48 && arr.charAt(1) <= 57) {  //정수가 10인경우
			num = 10;
			if(arr.charAt(2) == 83) { // S인경우
				
			}
			else if(arr.charAt(2) == 68) { // D인 경우
				num = (int) Math.pow(num, 2);
			}
			else if(arr.charAt(2) == 84) { // T인 경우
				num = (int) Math.pow(num, 3);
			}
			if(arr.length()==4) {
				if(arr.charAt(3) == 35) {// #인 경우
					num *= -1;
				}
				else if(arr.charAt(3) == 42) {// *인 경우
					num *= 2;
					if(i == 1)
						first_num *= 2;
					else if(i == 2)
						sec_num *= 2;
				}
			}
		}
		else {
			num = arr.charAt(0)-48;
			if(arr.charAt(1) == 83) { // S인경우
				
			}
			else if(arr.charAt(1) == 68) { // D인 경우
				num = (int) Math.pow(num, 2);
			}
			else if(arr.charAt(1) == 84) { // T인 경우
				num = (int) Math.pow(num, 3);
			}
			if(arr.length()==3) {
				if(arr.charAt(2) == 35) {// #인 경우
					num *= -1;
				}
				else if(arr.charAt(2) == 42) {// *인 경우
					num *= 2;
					if(i == 1)
						first_num *= 2;
					else if(i == 2)
						sec_num *= 2;
				}
			}
		}
		return num;
	}
}
