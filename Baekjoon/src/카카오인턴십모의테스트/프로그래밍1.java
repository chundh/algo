package īī�����Ͻʸ����׽�Ʈ;

import java.util.ArrayList;

public class ���α׷���1 {

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
		for(int i=0; i<board.length; i++) { // ������ �������� y������ ���� �����ִ°��� Ž��. �ƹ��͵� ������ 0 return
			if(board[i][y]!=0) {
				data = board[i][y];
				board[i][y] = 0;
				break;
			}
		}
		return data;
	}
	
	public static boolean delete(ArrayList<Integer> arr) {
		if(arr.get(arr.size()-1) == arr.get(arr.size()-2)) {// �յڰ� ���� ������ ������ ���� ����
			answer++;
			answer++;
			return true;
		}
		else
			return false;
	}

}
