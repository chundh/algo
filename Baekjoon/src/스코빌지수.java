
import java.util.PriorityQueue;

public class 스코빌지수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		
		solution(scoville, K);
	}
	public static void solution(int[] scoville, int K) {
		int answer=0;
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		for(int i=0; i<scoville.length; i++) {
			priorityQueue.add(scoville[i]);
		}
		
		while(true) {
			if(priorityQueue.size()==1) {
				answer = -1;
				break;
			}
			int a = priorityQueue.poll();
			if(a>=K)
				break;
			else 
				priorityQueue.add(a);
			int new_sco = priorityQueue.poll()+ priorityQueue.poll()*2;
			priorityQueue.add(new_sco);
			answer++;
		}
		System.out.println(answer);
	}

}
