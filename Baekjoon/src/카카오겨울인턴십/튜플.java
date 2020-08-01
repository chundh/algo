package 카카오겨울인턴십;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 튜플 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{{12345},{12345,2},{2,12345,3}}";
		
		solution(s);
	}
	
	public static void solution(String s) {
		ArrayList<String> arr = new ArrayList<String>();
		int start=2;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='}') {
				if(start>=s.length())
					break;
				arr.add(s.substring(start, i)+",");
				start = i+3;
			}
		}
		Collections.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				// TODO Auto-generated method stub
				if(arg0.length()>arg1.length())
					return 1;
				else
					return -1;
			}
			
		});
		String answer = "";
		int[] ans = new int[arr.size()];
		for(int i=0; i<arr.size(); i++) {
			int s_index = 0;
			System.out.println(arr.get(i) + " ----------------");
			for(int j=0; j<arr.get(i).length(); j++) {
				String data = "";
				if(arr.get(i).charAt(j)==',') {
					data = arr.get(i).substring(s_index, j);
					s_index = j+1;
					System.out.println(data);
					int flag=0;
					for(int k=0; k<i; k++) {
						if(ans[k] == Integer.valueOf(data)) {
							flag=1;
							break;
						}
					}
					if(flag==0) {
						ans[i] = Integer.valueOf(data);
						break;
					}
				}
				/*
				if(!answer.contains(data)){
					answer += data + ",";
					ans[i] = Integer.valueOf(data);
					break;
				}
				*/
			}
		}
		//answer = answer.substring(0, answer.length()-1);
		//System.out.println(answer);
		
		for(int i=0; i<ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
}
