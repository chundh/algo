package DFS;

import java.util.Scanner;

public class 안전영역_2468{
	static int cnt;
	static int now;
	static int max_cnt;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 행열 수
		int[][] arr = new int[n][n];
		boolean[][] check = new boolean[n][n];
		int max=0;
		for(int i=0; i<n; i++) {
			arr[i] = new int[n];
			check[i] = new boolean[n];
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
				check[i][j] = false;
				if(arr[i][j]>max)
					max = arr[i][j];
			}
		}
		max_cnt=0;
		now=0;
		for(int k=1; k<=max; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(check[i][j]==false) {
						cnt=0;
						sol(arr, check, i, j, cnt, n, k);
						if(cnt!=0)
							now++;
					}
				}
			}
			//System.out.println(k + "강수량일때 영역 : " + now);
			if(max_cnt<now) {
				max_cnt = now;
			}
			now=0;
			check = new boolean[n][n];
		}
		System.out.println(max_cnt);
	}

	public static void sol(int[][] arr, boolean[][] check, int x, int y, int c, int n, int k) {
		if(x<0 || y<0 || x>=n || y>=n)
			return;
		if(check[x][y]) {
			return;
		}
		
		check[x][y] = true;
		if(arr[x][y]>k) { //해당지역은 물에 잠기지 않음.
			cnt++;
			sol(arr, check, x, y+1, cnt, n, k);
			sol(arr, check, x, y-1, cnt, n, k);
			sol(arr, check, x+1, y, cnt, n, k);
			sol(arr, check, x-1, y, cnt, n, k);
		}
	}
}
