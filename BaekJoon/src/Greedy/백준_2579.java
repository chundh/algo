package Greedy;

import java.util.Scanner;

public class น้มุ_2579 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] list = new int[n+1];
		for(int i=1; i<=n; i++) {
			list[i] = sc.nextInt();
		}
		int a=0;
		int b=0;
		arr[0] = 0;
		arr[1] = list[1];
		if(n>=2)
			arr[2] = list[2] + list[1];
		for(int i=3; i<=n; i++) {
			a = list[i] + list[i-1] + arr[i-3];
			b = list[i] + arr[i-2];
			arr[i] = Math.max(a, b);
		}
		
		System.out.println(arr[n]);
	}
}
