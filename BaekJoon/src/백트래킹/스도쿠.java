package 백트래킹;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class 스도쿠 {
	static int flag=0;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<point> point = new ArrayList<point>();
	static int[][] board;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		board = new int[9][9];
		int cnt=0;
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				board[i][j] = sc.nextInt();
				if(board[i][j]==0) {
					point.add(new point(i,j));
					cnt++;
				}
			}
		}
		dfs(cnt, 0);
		bw.flush();
	}
	
	public static void dfs(int cnt, int idx) throws IOException {
		if(cnt==0) {
			flag=1;
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++)
					bw.write(Integer.toString(board[i][j]) + " ");
				bw.newLine();
			}
			bw.flush();
			System.exit(0);
			return;
		}
		if(flag==1)
			return;
		int i = point.get(idx).x;
		int j = point.get(idx).y;
		for(int k=1; k<10; k++) {
			if(isPossible(i, j, k)) {
				board[i][j] = k;
				cnt--;
				idx++;
				dfs(cnt, idx);
				board[i][j] = 0;
				cnt++;
				idx--;
			}
		}
		return;
	}
	
	
	public static boolean isPossible(int x, int y, int data) {
		for(int i=0; i<9; i++) {
			if(board[x][i]==data)
				return false;
			if(board[i][y]==data)
				return false;
		}
		int x_range, y_range;
		if(x<3)
			x_range = 0;
		else if(x<6)
			x_range = 3;
		else
			x_range = 6;
		if(y<3)
			y_range = 0;
		else if(y<6)
			y_range = 3;
		else
			y_range = 6;
		
		for(int i=x_range; i<x_range+3; i++) {
			for(int j=y_range; j<y_range+3; j++) {
				if(board[i][j] == data)
					return false;
			}
		}
		return true;
	}

}

class point{
	int x;
	int y;
	public point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
