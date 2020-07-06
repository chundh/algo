package Dynamic_Programming;

import java.util.Scanner;

public class น้มุ_1463 {

	static int[] arr;
	static int answer=-1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n+1];
		
		System.out.println(solution(n));
	}
	
	public static int solution(int k) {
		if(k==1) {
			return 0;
		}
		else if(arr[k]>0)
			return arr[k];

		arr[k] = solution(k-1)+1;
		if(k%2==0) {
			int data = solution(k/2)+1;
			if(data<arr[k])
				arr[k] = data;
		}
		if(k%3==0) {
			int data = solution(k/3)+1;
			if(data<arr[k])
				arr[k] = data;
		}
		return arr[k];
		
	}
}
