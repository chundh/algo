package Greedy;

import java.util.Arrays;

// 현재 효율성 문제!!

public class 저울 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] weight = {3, 1, 6, 2, 7, 30, 1};

		solution(weight);
	}
	
	public static void solution(int[] weight) {
		int cnt = 1;
		int data = 1;
		Arrays.sort(weight);
		boolean flag = false;
		while(true) {
			flag = false;
			if(cnt < weight[weight.length/2]) {
				for(int i=(weight.length)/2-1; i>=0; i--) {
					if(weight[i]<=cnt)
						cnt-=weight[i];
					if(cnt==0) {
						flag = true;
						break;
					}
				}
			}
			else {
				for(int i=weight.length-1; i>=0; i--) {
					if(weight[i]<=cnt)
						cnt-=weight[i];
					if(cnt==0) {
						flag = true;
						break;
					}
				}
			}
			if(flag==false) {
				break;
			}
			data++;
			cnt = data;
		}
		System.out.println(data);
	}
	

}
