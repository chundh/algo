package Dynamic_Programming;

import java.util.Scanner;

public class น้มุ_11726 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		arr[1] = 1;
		arr[2] = 2;
		if(n>=3) {
			for(int i=3; i<=n; i++) {
				arr[i] = arr[i-1] + arr[i-2];
				arr[i]%=10007;
			}
		}
		System.out.println(arr[n]);
	}
/* 1 : 1
 * 2 : 2
 * 3 : 3
 * 4 : 5
 * 5 : 8
 * 6 : 13
 * 7 : 21
 * 8 : 34
 * 9 : 55
 */
}