package Dynamic_Programming;

import java.util.Scanner;

public class น้มุ_2193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long[] arr = new long[n+1];
		arr[0] = 0;
		arr[1] = 1;
		if(n>=2)
			arr[2] = 1;
		if(n>=3) {
			for(int i=3; i<=n; i++) {
				arr[i] = arr[i-1] + arr[i-2];
			}
		}
		System.out.println(arr[n]);
	}

}
