package 카카오인턴십모의테스트;

import java.util.ArrayList;

public class 프로그래밍1 {

	static int answer = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
	
		solution(board, moves);
	}
	
	public static void solution(int[][] board, int[] moves) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0; i<moves.length; i++) {
			int data = check(board, moves[i]-1);
			if(arr.size()==0) {
				if(data !=0)
					arr.add(data);
				continue;
			}
			
			if(data != 0) {
				arr.add(data);
				if(delete(arr)){
					arr.remove(arr.size()-1);
					arr.remove(arr.size()-1);
				}
				
			}
		}
		System.out.println(answer);
	}
	
	public static int check(int[][] board, int y) {
		int data = 0;
		for(int i=0; i<board.length; i++) { // 인형을 집으려는 y값에서 가장 위에있는것을 탐색. 아무것도 없으면 0 return
			if(board[i][y]!=0) {
				data = board[i][y];
				board[i][y] = 0;
				break;
			}
		}
		return data;
	}
	
	public static boolean delete(ArrayList<Integer> arr) {
		if(arr.get(arr.size()-1) == arr.get(arr.size()-2)) {// 앞뒤가 같은 인형이 있으면 삭제 가능
			answer++;
			answer++;
			return true;
		}
		else
			return false;
	}

}
