package Dynamic_Programming;

import java.util.Scanner;

public class น้มุ_2156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] list = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = sc.nextInt();
		}
		list[0] = 0;
		list[1] = arr[1];
		if(n>=2) {
			list[2] = arr[1] + arr[2];
		}
		if(n>=3) {
			for(int i=3; i<=n; i++) {
				int a = arr[i] + arr[i-1] + list[i-3];
				int b = arr[i] + list[i-2];
				int c = list[i-1];
				list[i] = Math.max(c, Math.max(a, b));
			}
		}
		System.out.println(Math.max(list[n], list[n-1]));
		
	}

}
