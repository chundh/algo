package Greedy;

import java.util.Arrays;

public class 구명보트 {
	public static void main(String args[]) {
		int[] people = {40,40,40};
		int limit = 100;
		
		solution(people, limit);
	}
	
	public static void solution(int[] people, int limit) {
		Arrays.sort(people);
		int answer=0;
		int weight=0;
		int cnt=0;
		for(int i=0; i<people.length; i++) {
			weight+=people[i];
			cnt++;
			if(weight>limit) {
				System.out.println(weight);
				answer++;
				weight = people[i];
				cnt=0;
			}
			if(cnt==2) {
				System.out.println(weight);
				answer++;
				weight=0;
				cnt=0;
			}
				
		}
		answer++;
		System.out.println(answer);
	}
	
	/*
	public static void solution(int[] people, int limit) {
		boolean[] check = new boolean[people.length];
		int weight=0;
		int answer=0;
		for(int i=0; i<people.length; i++) {
			weight=0;
			int flag=0;
			for(int j=i; j<people.length; j++) {
				if(check[j] ==true) {
					if(j==people.length-1 && weight!=0) {
						System.out.println(weight);
						answer++;
						break;
					}
					continue;
				}
				flag=1;
				weight += people[j];
				check[j] = true;
				if(weight>limit) {
					weight-=people[j];
					check[j] = false;
				}
				if(j==people.length-1) {
					System.out.println(weight);
					answer++;
				}
			}
			if(flag==0)
				break;
		}
		System.out.println(answer);
	}
	*/
}
