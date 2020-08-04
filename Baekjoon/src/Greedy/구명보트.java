package Greedy;

import java.util.Arrays;

public class 구명보트 {
	public static void main(String args[]) {
		int[] people = {70,50,80};
		int limit = 100;
		
		solution(people, limit);
	}
	
	public static void solution(int[] people, int limit) {
		Arrays.sort(people);
		int answer=0;
		int min_idx=0;
		int max_idx=people.length-1;
		int cnt=1;
		int num = people.length;
		while(true) {
			int weight=0;
			if(num==0)
				break;
			if(max_idx<min_idx)
				break;
			weight+=people[max_idx];
			for(int i=min_idx; i<max_idx; i++) {
				if(weight+people[i]<=limit) {
					cnt++;
					weight+=people[i];
				}else {
					min_idx = i;
					break;
				}
			}
			num -= cnt;
			cnt=1;
			max_idx--;
			answer++;
		}
		System.out.println(answer);
	}
}
