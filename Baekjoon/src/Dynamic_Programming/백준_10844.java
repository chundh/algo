package Dynamic_Programming;

import java.util.Scanner;

/**
 * 2���� dp�� Ȱ���ؼ� Ǭ ����
 * dp[i][0] ���� i���� ���ڷ� �̷������ 0���� ������ ���� ������ ���ִ�.
 */

public class ����_10844 {

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
