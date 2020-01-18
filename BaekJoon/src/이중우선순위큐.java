import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		
		solution(operations);
	}
	public static void solution(String[] operations) {
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		int[] answer = new int[2];
		int count=0;
		for(int i=0; i<operations.length; i++) {
			String opt = operations[i].split(" ")[0];
			String n = operations[i].split(" ")[1];
			int num = Integer.valueOf(n);
			if(opt.equals("I")) {
				pq1.add(num);
				pq2.add(num);
				count++;
			}
			if(opt.equals("D")) {
				if(!pq1.isEmpty()) {
					if(num<0) {
						int a = pq1.peek();
						pq1.remove(a);
						pq2.remove(a);
					}
					else {
						int a = pq2.peek();
						pq1.remove(a);
						pq2.remove(a);
					}
				}
			}
		}
		if(pq1.isEmpty()) {
			answer[0] = 0;
			answer[1] = 0;
		}
		else {
			answer[0] = pq2.poll();
			answer[1] = pq1.poll();
		}
			
		System.out.println(answer[0] + " , " + answer[1]);
	}
}
