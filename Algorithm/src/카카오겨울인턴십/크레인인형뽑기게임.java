package 카카오겨울인턴십;

import java.util.ArrayList;

public class 크레인인형뽑기게임 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		solution(board, moves);
	}
	
	public static void solution(int[][] board, int[] moves) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int answer = 0;
		for(int i=0; i<moves.length; i++) {
			int y = moves[i]-1;
			int num = 0;
			for(int j=0; j<board[0].length; j++) {
				if(board[j][y]!=0) {
					num = board[j][y];
					board[j][y] = 0;
					break;
				}
			}
			if(num != 0) {
				System.out.println(num + "번 인형 선택");
				if(arr.size()==0) {
					System.out.println(num + "번 인형 삽입");
					arr.add(num);
				}
				else {
					int num1 = arr.remove(arr.size()-1);
					if(num==num1) {  //두 인형이 같아서 사라져야하는 경우
						System.out.println(num + "번 인형 삭제");
						answer++;
						answer++;
					}
					else {  //다르므로 배열에 넣어야 하는 경우
						System.out.println(num + "번 인형 삽입2");
						arr.add(num1);
						arr.add(num);
					}
				}				
			}
		}
		System.out.println(answer);
	}

}
