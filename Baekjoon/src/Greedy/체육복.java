package Greedy;

import java.util.Arrays;

public class Ã¼À°º¹ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] lost = {1,2};
		int[] reserve = {2, 3};
		
		solution(n, lost, reserve);
	}
	
	public static void solution(int n, int[] lost, int[] reserve) {
		Arrays.sort(lost);
		Arrays.sort(reserve);
		
		int cnt = lost.length;
		int reserve_idx = 0;
		
		for(int i=0; i<lost.length; i++) {
			for(int j=0; j<reserve.length; j++) {
				if(lost[i]==reserve[j]) {
					cnt--;
					lost[i] = -1;
					reserve[j] = -1;
				}
			}
		}
		
		for(int i=0; i<lost.length; i++) {
			if(lost[i]==-1)
				continue;
			int idx = lost[i];
			if(reserve_idx>=reserve.length)
				break;
			for(int j=reserve_idx; j<reserve.length; j++) {
				if(reserve[j] == -1)
					continue;
				if(idx == reserve[j]) {
					reserve_idx = j+1;
					cnt--;
					break;
				}
				else if(idx-1 == reserve[j]) {
					reserve_idx = j+1;
					cnt--;
					break;
				}
				else if(idx+1 == reserve[j]) {
					reserve_idx = j+1;
					cnt--;
					break;
				}					
			}
		}
		System.out.println(n-cnt);
	}
}
