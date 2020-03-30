package 이스트소프트코테;

import java.util.ArrayList;

public class task4 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker; John dklek Doe";
		String C = "Example";
		
		solution(S,C);
	}
	
	public static void solution(String S, String C) {
		String[] arr = S.split("; ");
		String ans = "";
		C = C.toLowerCase();
		ArrayList<String> answer = new ArrayList<String>();
		for(int i=0; i<arr.length; i++) {
			String[] data = arr[i].split(" ");
			String first = data[0];
			first = first.toLowerCase();
			String last = data[data.length-1];
			String[] last_data = last.split("-");
			String last_str = "";
			for(int j=0; j<last_data.length; j++) {
				last_str += last_data[j];
			}
			last = last_str;
			last = last.toLowerCase();
			String mail = "<" + last + "_" + first + "@" + C + ".com>";
			if(answer.contains(mail)) {
				int cnt=2;
				while(true){
					if(answer.contains(mail)) {
						mail = "<" + last + "_" + first + cnt + "@" + C + ".com>";
						cnt++;
					}
					else {
						answer.add(mail);
						break;
					}
				}
			}
			else {
				answer.add(mail);
			}
			for(int j=0; j<data.length; j++) {
				ans += data[j] + " ";
			}
			ans += mail;
			if(i != arr.length-1) {
				ans += "; ";
			}
		}
		System.out.println(ans);
	}
}
