package SW_expert_academy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 보물상자비밀번호 {
	public static void main(String args[]) {
		int T = 5;	
		Scanner sc = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<String>();
		for(int i=0; i<T; i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			String data = sc.next();
			arr.clear();
			for(int j=0; j<N/4; j++) {
				String split_data = data.substring(0,N/4);
				if(!arr.contains(split_data)) {
					arr.add(split_data);
				}
				split_data = data.substring(N/4, 2*N/4);
				if(!arr.contains(split_data)) {
					arr.add(split_data);
				}
				split_data = data.substring(2*N/4, 3*N/4);
				if(!arr.contains(split_data)) {
					arr.add(split_data);
				}
				split_data = data.substring(3*N/4, 4*N/4);
				if(!arr.contains(split_data)) {
					arr.add(split_data);
				}
				String new_data = data.substring(4*N/4-1, 4*N/4) + data.substring(0, 4*N/4 -1);
				data = new_data;
			}
			
			Collections.sort(arr);
			int answer = change_num(arr.get(arr.size()-K));
			System.out.println("#" + i + " " + answer);
		}
	}
	
	public static int change_num(String data) {
		int sum = 0;
		for(int i=0; i<data.length(); i++) {
			int a=0;
			if(data.charAt(i) == 'A')
				a = 10;
			else if(data.charAt(i) == 'B')
				a = 11;
			else if(data.charAt(i) == 'C')
				a = 12;
			else if(data.charAt(i) == 'D')
				a = 13;
			else if(data.charAt(i) == 'E')
				a = 14;
			else if(data.charAt(i) == 'F')
				a = 15;
			else {
				a = Integer.valueOf(data.charAt(i))-48;
			}
			sum += a * Math.pow(16, data.length()-i-1);
		}
		return sum;
	}
}
