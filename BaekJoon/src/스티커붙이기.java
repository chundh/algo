
import java.util.Scanner;

public class 스티커붙이기 {
	static boolean flag = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		boolean[][] board = new boolean[n][m];
		boolean[][] visit = new boolean[n][m];
		sticker[] stick = new sticker[k];
		for(int i=0; i<k; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			stick[i] = new sticker(x,y);
			for(int j=0; j<x; j++) {
				for(int l=0; l<y; l++) {
					stick[i].arr[j][l] = sc.nextInt();
				}
			}	
		}		
		
		for(int i=0; i<k; i++) {
			flag = false;
			//System.out.println("======stick#" + i + "======");
			for(int j=0; j<4; j++) {
				visit = new boolean[n][m];
				check(n,m,stick[i].arr,board,0,0, visit);
				if(flag==false) { // 현재 각도에서는 부착이 안되므로 90도 회전
					stick[i].arr = turn(stick[i].arr);
					//System.out.println("stick#" + i + " " + j + "회전");
				}
				if(flag==true)
					break;
			}
			visit = new boolean[n][m];
		}
		
		int answer = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(board[i][j])
					answer++;
			}
		}
		System.out.println(answer);
	}
	
	public static void check(int n, int m, int[][] arr, boolean[][] board, int x, int y, boolean[][] visit) {
		if(flag==true) {
			return;
		}
		if(x>=n || y>=m)
			return;
		if(visit[x][y])
			return;
		if(board[x][y]) {
			check(n,m,arr,board,x,y+1,visit);
			check(n,m,arr,board,x+1,y,visit);
		}
		visit[x][y] = true;
		int now_x = x;
		int now_y = y;
		int flag_data=0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j] == 1) {
					if(flag_data==0) {
						flag_data=1;
						now_x = x-i;
						now_y = y-i;
					}
					if(now_x+i>=n || now_y+j>=m) {
						check(n,m,arr,board,x,y+1,visit);
						check(n,m,arr,board,x+1,y,visit);
						return;
					}
					if(board[now_x+i][now_y+j]) {
						check(n,m,arr,board,x,y+1,visit);
						check(n,m,arr,board,x+1,y,visit);
						return;
					}
				}
			}
		}
		  //x,y 에 스티커를 붙일 수 있음
			//System.out.println(x+ " , " + y + " 좌표에 ");
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr[0].length; j++) {
					//System.out.print(arr[i][j] + " ");
					if(arr[i][j] == 1) {
						board[x+i][y+j] = true;
						flag = true;
					}
				}
				//System.out.println();
			}		
	}
	
	public static int[][] turn(int[][] arr){
		int max=0;
		int min=0;
		int[][] new_arr;
		if(arr.length>arr[0].length) {
			max = arr.length;
			min = arr[0].length;
			new_arr = new int[arr[0].length][arr.length];
			for(int i=0; i<min; i++) {  // 5
				for(int j=0; j<max; j++) {  // 2
					new_arr[i][j] = arr[arr.length-j-1][i];
				}
			}
		}
		else {
			max = arr[0].length;
			min = arr.length;
			new_arr = new int[arr[0].length][arr.length];
			for(int i=0; i<max; i++) {  // 5
				for(int j=0; j<min; j++) {  // 2
					new_arr[i][j] = arr[arr.length-j-1][i];
				}
			}
		}
		return new_arr;
	}

}

class sticker{
	int[][] arr;
	public sticker(int x, int y) {
		arr = new int[x][y];
	}
}