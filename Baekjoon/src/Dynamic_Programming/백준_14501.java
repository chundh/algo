package Dynamic_Programming;

import java.util.Scanner;

public class น้มุ_14501 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		for(int i=1; i<=n; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = p[1];
		int answer = 0;
		for(int i=1; i<=n; i++){
			int max = 0;
			for(int j=i-1; j>0; j--){
				if(j+t[j]<=i)
					max = Math.max(max, dp[j]);
			}
			if(i+t[i]<=n+1)
				dp[i] = max + p[i];
			else
				dp[i] = max;
			answer = Math.max(dp[i], answer);
		}
		System.out.println(answer);
	}

}
