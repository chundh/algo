package īī���ܿ����Ͻ�;

import java.util.ArrayList;

public class ũ���������̱���� {

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
				System.out.println(num + "�� ���� ����");
				if(arr.size()==0) {
					System.out.println(num + "�� ���� ����");
					arr.add(num);
				}
				else {
					int num1 = arr.remove(arr.size()-1);
					if(num==num1) {  //�� ������ ���Ƽ� ��������ϴ� ���
						System.out.println(num + "�� ���� ����");
						answer++;
						answer++;
					}
					else {  //�ٸ��Ƿ� �迭�� �־�� �ϴ� ���
						System.out.println(num + "�� ���� ����2");
						arr.add(num1);
						arr.add(num);
					}
				}				
			}
		}
		System.out.println(answer);
	}

}
