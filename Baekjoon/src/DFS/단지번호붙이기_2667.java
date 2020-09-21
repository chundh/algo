package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 단지번호붙이기_2667 {
	static int cnt=1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		boolean[][] check = new boolean[n][n];
		for(int i=0; i<n; i++) {
			arr[i] = new int[n];
			check[i] = new boolean[n];
			String data = sc.next();
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(data.substring(j, j+1));
				check[i][j] = false;
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]==1 && check[i][j]==false) {
					cnt=0;
					sol(arr, check, i, j, cnt, n);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	public static void sol(int[][] arr, boolean[][] check, int x, int y, int c, int n) {
		if(x<0 || y<0 || x>=n || y>=n)
			return;
		if(check[x][y] || arr[x][y]==0) {
			return;
		}
		
		check[x][y] = true;
		cnt++;
		sol(arr, check, x, y+1, cnt, n);
		sol(arr, check, x, y-1, cnt, n);
		sol(arr, check, x+1, y, cnt, n);
		sol(arr, check, x-1, y, cnt, n);
	}

}
