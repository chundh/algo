package Dynamic_Programming;

import java.util.Scanner;

public class น้มุ_1932 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] list = new int[n][n];
		for(int i=n-1; i>=0; i--) {
			for(int j=n-1-i; j>=0; j--) {
				int a = sc.nextInt();
				list[n-1-i][j] = a;
			}
		}
		
		for(int i=n-1; i>=0; i--) {
			for(int j=0; j<=i; j++) {
				if(i==n-1) 
					continue;
				else{
					list[i][j] = Math.max(list[i+1][j], list[i+1][j+1]) + list[i][j];
				}
			}
		}
		/*
		for(int i=n-1; i>=0; i--) {
			for(int j=0; j<=i; j++) {
				System.out.print(list[i][j] + " ");
			}
			System.out.println();
		}
		*/
		System.out.println(list[0][0]);
	}

}
