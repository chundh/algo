package CodingTest.카카오인턴십모의테스트;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 프로그래밍2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

		solution(s);
	}
	
	public static void solution(String s) {
		int start=0;
		int end=0;
		ArrayList<String> arr = new ArrayList<String>();
		for(int i=1; i<s.length()-1; i++) {
			if(s.charAt(i)=='{')
				start = i;
			if(s.charAt(i)=='}')
				end = i;
			if(end>start) {
				arr.add(s.substring(start+1, end));
				start=0;
				end=0;
			}
		}
		Collections.sort(arr, new Sort());
		int[] answer = new int[arr.size()];
		ArrayList<Integer> answer_data = new ArrayList<Integer>();
		answer_data.add(Integer.valueOf(arr.get(0)));
		answer[0] = answer_data.get(0);
		System.out.println(answer[0]);
		for(int i=1 ;i<arr.size(); i++) {
			String[] data = arr.get(i).split(",");
			for(int j=0; j<data.length; j++) {
				int val = Integer.valueOf(data[j]);
				if(!answer_data.contains(val)) {
					answer_data.add(val);
					answer[i] = val;
				}
			}
		}
	}

}


class Sort implements Comparator<String>{

	@Override
	public int compare(String arg0, String arg1) {
		if(arg0.length()>arg1.length()) {
			return 1;
		}
		else
			return -1;
	}
}
