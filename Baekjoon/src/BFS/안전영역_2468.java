package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 안전영역_2468{
	static class spot{
		int x;
		int y;

		public spot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 행열 수
		int[][] arr = new int[n][n];
		int max = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				arr[i][j] = sc.nextInt();
				max = Math.max(max, arr[i][j]);
			}
		}
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		int answer = 0;
		for(int k=0; k<max; k++){
			boolean[][] check = new boolean[n][n];
			int cnt = 0;
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(arr[i][j]>k && !check[i][j]){
						cnt++;
						check[i][j] = true;
						Queue<spot> queue = new LinkedList<>();
						queue.offer(new spot(i,j));
						while(!queue.isEmpty()){
							spot temp = queue.poll();
							int x = temp.x;
							int y = temp.y;
							for(int idx=0; idx<4; idx++){
								int temp_x = x + dx[idx];
								int temp_y = y + dy[idx];
								if(temp_x<0 || temp_x>=n || temp_y<0 || temp_y>=n)
									continue;
								if(arr[temp_x][temp_y] > k && !check[temp_x][temp_y]){
									check[temp_x][temp_y] = true;
									queue.offer(new spot(temp_x, temp_y));
								}
							}
						}
					}
				}
			}
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);
	}
}
