package Greedy;

import java.util.ArrayList;

public class 큰수만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String number = "777777";
		int k = 2;
		
		//solution(number, k, 0, "", 0);
		sol(number, k);
		
	}
	

	public static void sol(String number, int k) {
		ArrayList<Character> arr = new ArrayList<Character>();
		String answer = "";
		int cnt=0;
		for(int i=0; i<number.length(); i++) {
			if(cnt==k) {
				for(int j=i; j<number.length(); j++) {
					arr.add(number.charAt(j));
				}
				System.out.println(arr.size());
				break;
			}
			if(arr.size()==0){
				arr.add(number.charAt(i));
			}
			else if(arr.get(arr.size()-1)<number.charAt(i)) {
				for(int j=arr.size()-1; j>=0; j--) {
					if(arr.get(j)<number.charAt(i)) {
						arr.remove(j);
						cnt++;
					}
					else {
						break;
					}
					if(cnt==k)
						break;
				}
				arr.add(number.charAt(i));
				System.out.println("#2 " + number.charAt(i) + " , " + cnt);
			}
			else{
				arr.add(number.charAt(i));
				System.out.println("#3 " + number.charAt(i));
			}
		}
			
		for(int i=0; i<number.length()-k; i++) {
			answer += arr.get(i);
		}
		System.out.println(answer);
	}
}
