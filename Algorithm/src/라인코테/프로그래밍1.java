package 라인코테;

import java.util.ArrayList;

public class 프로그래밍1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputString = ">_<";
		solution(inputString);
	}
	
	// 괄호는 < { ( [ 4가지 경우가 존재. 닫는게 먼저 나오면 -1 return. 그게아니면 정상적인 괄호의 수 return;
	public static void solution(String inputString) {
		ArrayList<Integer> arr1= new ArrayList<Integer>();
		ArrayList<Integer> arr2= new ArrayList<Integer>();
		ArrayList<Integer> arr3= new ArrayList<Integer>();
		ArrayList<Integer> arr4= new ArrayList<Integer>();
		for(int i=0; i<inputString.length(); i++) {
			if(inputString.charAt(i)=='<') {
				arr1.add(1);
			}
			else if(inputString.charAt(i)=='{') {
				arr2.add(1);
			}
			else if(inputString.charAt(i)=='(') {
				arr3.add(1);
			}
			else if(inputString.charAt(i)=='[') {
				arr4.add(1);
			}
			else if(inputString.charAt(i)=='>') {
				arr1.add(-1);
			}
			else if(inputString.charAt(i)=='}') {
				arr2.add(-1);
			}
			else if(inputString.charAt(i)==')') {
				arr3.add(-1);
			}
			else if(inputString.charAt(i)==']') {
				arr4.add(-1);
			}
		}
		int answer = 0;
		int ans = check(arr1);
		if(ans==-1) {
			answer = -1;
			return;
		}
		else
			answer += ans;
		ans = check(arr2);
		if(ans==-1) {
			answer = -1;
			return;
		}
		else
			answer += ans;
		ans = check(arr3);
		if(ans==-1) {
			answer = -1;
			return;
		}
		else
			answer += ans;
		ans = check(arr4);
		if(ans==-1) {
			answer = -1;
			return;
		}
		else
			answer += ans;
		System.out.println(answer);
	}

	public static int check(ArrayList<Integer> arr) {
		int cnt=0;
		int ans=0;
		for(int i=0; i<arr.size(); i++) {
			if(arr.get(i)==-1) {
				cnt--;
			}
			else if(arr.get(i) == 1) {
				cnt++;
			}
			if(cnt==0) {
				ans++;
			}
			else if(cnt<0)
				return -1;
		}
		return ans;
	}
	
}
