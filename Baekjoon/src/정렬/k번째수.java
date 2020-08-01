package 정렬;
import java.util.ArrayList;
import java.util.List;

public class k번째수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		List<Integer> answer = new ArrayList();
		List<Integer> new_arr = new ArrayList();
		
		for(int i=0; i<commands.length; i++) {
			new_arr.clear();
			System.out.println(commands[i][0] + " , " + commands[i][1] + commands[i][2]);
			for(int j=commands[i][0]-1; j<commands[i][1]; j++) {
				new_arr.add(array[j]);
			}
			new_arr.sort(null);
			for(int k=0; k<new_arr.size(); k++) {
				System.out.println(new_arr.get(k));
			}
			answer.add(new_arr.get(commands[i][2]-1));
		}
		
		for(int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}
		int[] answers = new int[answer.size()];
		for(int i=0; i<answer.size(); i++) {
			answers[i] = answer.get(i);
		}
	}

}
