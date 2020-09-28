package Dynamic_Programming;

import java.util.Scanner;

public class 백준_10844 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n+1][10];
		for(int i=1; i<10; i++){
			dp[1][i] = 1;
		}
		if(n!=1) {
			for(int i=2; i<=n; i++) {
				for(int j=0; j<=9; j++){
					if(j==0){
						dp[i][j] = dp[i-1][j+1];
					}
					else if(j==9){
						dp[i][j] = dp[i-1][j-1];
					}else {
						dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
					}
					dp[i][j] %= 1000000000;
				}
			}
		}
		long answer = 0;
		for(int i=0; i<=9; i++){
			answer += dp[n][i];
		}
		System.out.println(answer%1000000000);
	}
}


/*
 * 1 : 9 1~9
 * 2 : 17
 * 3 : 101 121 123 210 212 232 234 4개씩 6개 878 876 898 987 989  24 + 2 + 3 + 3= 32
 * 4 : 1010 1012 1210 1212 1232 1234; 2101 2121 2123 2321 2323 2343 2345; 7개씩 6개  8765 8767 8787 8789 8987 8989; 9876 9878  42 + 6 + 6 + 2 = 56
 * ~8 ~15 ~24 ~35
 */