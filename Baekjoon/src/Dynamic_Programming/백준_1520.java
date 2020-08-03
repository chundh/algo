package Dynamic_Programming;

import java.util.Scanner;

public class 백준_1520 {

	static int[][] arr;
	static int m, n;
	static int answer =0;
	static int[][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		arr = new int[m][n];
		dp = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
				dp[i][j] = -1;
			}
		}
		sc.close();
		System.out.println(solution(0, 0));
	}

	public static int solution(int x ,int y) {
		if(x==m-1 && y==n-1) {
			answer++;
			return 1;
		}
		if(dp[x][y]>=0)
			return dp[x][y];
		if(dp[x][y] == -1) { //해당 지점에 방문한 적이 없음
			dp[x][y] = 0;
		}
		if(x+1<m && arr[x][y]>arr[x+1][y])
			dp[x][y] += solution(x+1, y);
		if(x-1>=0 && arr[x][y]>arr[x-1][y])
			dp[x][y] += solution(x-1, y);
		if(y+1<n && arr[x][y]>arr[x][y+1])
			dp[x][y] += solution(x, y+1);
		if(y-1>=0 && arr[x][y]>arr[x][y-1])
			dp[x][y] += solution(x, y-1);
		
		return dp[x][y];
		
	}
}
