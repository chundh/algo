package Greedy;

import java.util.Scanner;

public class น้มุ_1082 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int min = 51;
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			if(min>arr[i])
				min = arr[i];
		}
		int money = sc.nextInt();
		
		int now_money = money % min;
		int idx = money/min;
		int[] list = new int[idx];
		int start=0;
		for(int i=0; i<idx; i++) {
			for(int j=n-1; j>=0; j--) {
				if(now_money+min >= arr[j]) {
					if(start==0 && j==0)
						break;
					list[i] = j;
					now_money += min - arr[j];
					start = -1;
					break;
				}
			}
			if(start==0) {
				now_money+=min;
			}
		}
		String answer = "";
		for(int i=0; i<idx; i++) {
			if(list[i]!=0) {
				for(int j=i; j<idx; j++) {
					answer += String.valueOf(list[j]);
				}
				break;
			}
		}
		if(answer.equals(""))
			answer = "0";
		System.out.println(answer);
	}
}
