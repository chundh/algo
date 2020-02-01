package kakao_test_2018;

import java.util.ArrayList;

public class n진수게임 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 16; //진법
		int t = 16; //미리 구해놓을 개수
		int m = 2; //게임에 참여하는 사람
		int p = 1; //참가순서
		
		solution(n,t,m,p);
	}
	 public static String convertNJinsu(int num, int base) {
	        String numArray = "0123456789ABCDEF";

	        StringBuilder njinsu = new StringBuilder();
	        while (num > 0) {
	            njinsu.insert(0, numArray.charAt(num % base));
	            num = num / base;
	        }

	        return njinsu.toString();
	}
	public static void solution(int n, int t, int m, int p) {		
		String answer="";
		String index="0";
		int num = 1;
		ArrayList<String> arr = new ArrayList<String>();
		while(true){	
			String data = convertNJinsu(num, n);
			index += data;
			if(index.length()>=p+(t-1)*m) {
				break;
			}
			num++;
		}
		for(int i=p-1; i<index.length(); i=i+m) {
			if(answer.length()==t)
				break;
			answer += index.substring(i, i+1);
		}
		System.out.println(answer);
	}

}
