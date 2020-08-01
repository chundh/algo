package Dynamic_Programming;

import java.util.Scanner;

public class น้มุ_1149 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int answer = 0;
		int[][] arr = new int[n][3];
		int[][] list = new int[n][3];

		for(int i=0; i<n; i++) {
			for(int j=0; j<3; j++) {
				list[i][j] = sc.nextInt();
			}
		}
		arr[0][0] = list[0][0];
		arr[0][1] = list[0][1];
		arr[0][2] = list[0][2];
		
		for(int i=1; i<n; i++) {
			arr[i][0] = Math.min(arr[i-1][1], arr[i-1][2]) + list[i][0];
			arr[i][1] = Math.min(arr[i-1][0], arr[i-1][2]) + list[i][1];
			arr[i][2] = Math.min(arr[i-1][1], arr[i-1][0]) + list[i][2];
		}
		answer = arr[n-1][0];
		for(int i=0; i<3; i++) {
			if(answer>arr[n-1][i])
				answer = arr[n-1][i];
		}
		System.out.println(answer);
		
	}
}
