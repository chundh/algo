package 이스트소프트코테;

import java.util.Arrays;

public class task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,2,3,3,5,6,7,8,9,3,10,11,13};
		
		solution(A);
	}

	public static void solution(int[] A) {
		Arrays.sort(A);
		int cnt=0;
		int[] arr = new int[100000];
		int index = A[0];
		int max=0;
		int answer=0;
		for(int i=0; i<A.length; i++) {
			if(A[i] == index) {
				cnt++;
			}
			else {
				arr[index] = cnt;
				if(index==cnt) {
					if(answer<index)
						answer = index;
				}
				cnt=0;
				index = A[i];
				i--;
			}
			if(max<A[i])
				max = A[i];
		}
		arr[index] = cnt;
		if(index==cnt) {
			if(answer<index)
				answer = index;
		}
		/*
		for(int i=1; i<=max; i++) {
			System.out.println(i + " : " + arr[i]);
			if(i==arr[i]) {
				if(answer<i)
					answer = i;
			}
		}
		*/
		System.out.println(answer);
	}
}
