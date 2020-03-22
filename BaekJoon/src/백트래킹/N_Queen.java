package 백트래킹;

import java.util.Scanner;

public class N_Queen {
	static int answer=0;
	public static int n;
    public static int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			int[] col = new int[n];
			col[0] = i;
			
			dfs(col, 0);
		}
		
		//backtrack(arr,n,0,0);
		
		System.out.println(count);
	}
	
	public static void dfs(int[] col, int row) {
        if(row == n-1) {
            count++;
        }else {
            // 1열 부터 N 열까지 반복하면서 (row+1, i)에 퀸을 놓을 수 있는경우가 있는지 확인한다.
            // 있으면 다음행의 dfs를 호출한다.
            for(int i = 0; i < n; i++) {
                col[row+1] = i;
                if(isPossible(col, row+1)) {
                    dfs(col, row+1);
                }
            }
        }
    }
	public static boolean isPossible(int[] col, int row) {
        // 1행부터 row 행까지 같은 열 혹은 대각선에 위치하는 퀸이 있는지 확인한다.
        
        for(int i=0; i < row; i++) {
            // i 행과 row 행의 열 값이 같으면 퀸을 놓을수 없다. 
            if(col[i] == col[row]) return false;
            
            // i 행과 row 행의 열값이 대각선에 위치하는 절대값이면 안된다.
            if(Math.abs(i - row) == Math.abs(col[i] - col[row])) return false;
        }
        return true;
    }
	
	public static void backtrack(int[][] arr, int n, int cnt, int y) {
		if(cnt==n) {
			answer++;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("----------------");
			return;
		}
		for(int i=0; i<n; i++) {
			for(int j=y; j<n; j++) {
				if(arr[i][j]==0) {
					if(path(arr,i,j,cnt)) {
						arr[i][j] = 1;
						cnt++;
						//System.out.println(i + " , " + j + " 퀸 추가 " + cnt);
						backtrack(arr,n,cnt, j+1);
						arr[i][j]=0;
						cnt--;
					}
				}
			}
		}
	}
	
	public static boolean path(int[][] arr, int x, int y, int cnt) {
		int flag=0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {					
				if(arr[i][j]==1) {
					flag++;
					if(x==i || y==j || Math.abs(x-y)==Math.abs(i-j) || Math.abs(x+y)==Math.abs(i+j)){
						return false;
					}
				}
				if(cnt==flag) {
					return true;
				}
			}
		}
		return true;
	}

}
