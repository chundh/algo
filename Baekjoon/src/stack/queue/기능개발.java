package stack.queue;

public class 기능개발 {
	public static void main(String args[]) {
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		int[] finish = new int[speeds.length];
		int[] answers = new int[speeds.length];
		int first_index=0;
		int last_index = 0;
		int answer_index=0;
		int min=0;
		int cnt=0;
		for(int i=0; i<speeds.length; i++) {
			finish[i] = (100-progresses[i])/speeds[i];
			System.out.println(finish[i]);
			
		}
		min = finish[0];
		for(int i=1; i<speeds.length; i++) {
			cnt++;
			if(finish[i]>min) {
				answers[answer_index] = cnt;
				answer_index++;
				cnt=0;
				min = finish[i];
			}
		}
		cnt++;
		answers[answer_index] = cnt;
		int[] answer = new int[answer_index+1];
		for(int i=0; i<answer_index+1; i++) {
			answer[i] = answers[i];
		}
	}
}
