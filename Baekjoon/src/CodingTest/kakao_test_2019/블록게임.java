package CodingTest.kakao_test_2019;

import java.util.ArrayList;

/*
 ����� ���� �� �ִ� ����� ���� 5������ �������ִ�.  ó�� 0�̾ƴ� ������ ����� �ľ��ϰ� ���� ����� ������ �ش� �ε������� 0���� ��ȯ, answer+2.
 üũ�� ����� ���� �迭�� �����Ͽ� �ߺ�üũ ���� �ʵ��� �����.
                  .   . 
 .      .     .   .   .
 ...   ...  ...  ..   ..  
 */

public class ��ϰ��� {
	static int answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{0,0,0,0,0,0,0,6,0,0},{0,0,0,0,5,0,6,6,6,0},{0,0,0,4,5,5,5,0,0,0},
				{0,0,3,4,4,4,8,0,0,0},{1,2,3,3,3,8,8,0,0,0},{1,2,2,2,0,7,8,0,0,0},{1,1,0,0,7,7,7,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0}};
		solution(board);
	}
	public static void solution(int[][] board) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int[][] remake_board = new int[board.length+4][board.length+4];
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				remake_board[i+2][j+2] = board[i][j];
			}
		}
		for(int i=2; i<board.length+2; i++) {
			for(int j=2; j<board.length+2; j++) {
				if(remake_board[i][j] != 0) {  //����� ����.
					if(!arr.contains(remake_board[i][j])) {
						
						if(check_shape(remake_board, i, j, remake_board[i][j])==0) { //����� ���� �����.
							System.out.println(remake_board[i][j] + " : 0�� ���");
							arr.add(remake_board[i][j]);
						}
						else {
							if(check_shape(remake_board, i, j, remake_board[i][j])==1) {
								System.out.println(remake_board[i][j] + " : 1�� ���");
								if(check_row(remake_board,i,j+1)) {
									if(check_row(remake_board,i,j+2)) {
										System.out.println(remake_board[i][j] + " : answer�߰�");
										//arr.clear();
										answer++;
										remake_board[i][j]=0;
										remake_board[i+1][j]=0;
										remake_board[i+1][j+1]=0;
										remake_board[i+1][j+2]=0;
										j=0;
									}
								}
							}
							else if(check_shape(remake_board, i, j, remake_board[i][j])==2) {
								System.out.println(remake_board[i][j] + " : 2�� ���");
								if(check_row(remake_board,i,j-1)) {
									if(check_row(remake_board,i,j+1)) {
										System.out.println(remake_board[i][j] + " : answer�߰�");
										answer++;
										remake_board[i][j]=0;
										remake_board[i+1][j]=0;
										remake_board[i+1][j+1]=0;
										remake_board[i+1][j-1]=0;
										j=0;
									}
								}
							}
							else if(check_shape(remake_board, i, j, remake_board[i][j])==3) {
								System.out.println(remake_board[i][j] + " : 3�� ���");
								if(check_row(remake_board,i,j-1)) {
									if(check_row(remake_board,i,j-2)) {
										System.out.println(remake_board[i][j] + " : answer�߰�");
										answer++;
										remake_board[i][j]=0;
										remake_board[i+1][j]=0;
										remake_board[i+1][j-1]=0;
										remake_board[i+1][j-2]=0;
										j=0;
									}
								}
							}
							else if(check_shape(remake_board, i, j, remake_board[i][j])==4) {
								System.out.println(remake_board[i][j] + " : 4�� ���");
								if(check_row(remake_board,i+1,j-1)) {
									System.out.println(remake_board[i][j] + " : answer�߰�");
									answer++;
									remake_board[i][j]=0;
									remake_board[i+1][j]=0;
									remake_board[i+2][j]=0;
									remake_board[i+2][j-1]=0;
									j=0;
								}
							}
							else if(check_shape(remake_board, i, j, remake_board[i][j])==5) {
								System.out.println(remake_board[i][j] + " : 5�� ���");
								if(check_row(remake_board,i+1,j+1)) {
									System.out.println(remake_board[i][j] + " : answer�߰�");
									answer++;
									remake_board[i][j]=0;
									remake_board[i+1][j]=0;
									remake_board[i+2][j]=0;
									remake_board[i+2][j+1]=0;
									j=0;
								}
							}
							
						}
					}
				}
			}
		}
		System.out.println("Answer : " + answer);
	}
	
	public static int check_shape(int[][] remake_board, int x, int y, int data) {
		if(remake_board[x+1][y]==data) {
			if(remake_board[x+1][y+1]==data) {
				if(remake_board[x+1][y+2]==data) { //1�� ����� ���
					return 1;
				}
				if(remake_board[x+1][y-1]==data) { //2�� ����� ���
					return 2;
				}
			}
			if(remake_board[x+1][y-1]==data && remake_board[x+1][y-2]==data)
				return 3;
			if(remake_board[x+2][y]==data) {
				if(remake_board[x+2][y-1]==data) {
					return 4;
				}
				if(remake_board[x+2][y+1]==data) {
					return 5;
				}
			}
		}
		
		return 0;
	}
	
	public static boolean check_row(int[][]remake_board, int x, int y) {
		for(int i=x; i>=0; i--) {
			if(remake_board[i][y]!=0) { //����� ������ ��ġ ���� �ٸ� ����� �ִ� ���
				return false;
			}
		}
		return true;
	}

}
