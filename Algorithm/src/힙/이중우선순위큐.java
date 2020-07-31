package 힙;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 이중우선순위큐 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] operations = {"I 16", "I -5643" , "D -1", "D 1", "D 1", "I 123", "D -1"};
		
		int max=0;
		int min=0;
		
		PriorityQueue<Integer> max_queue = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> min_queue = new PriorityQueue<>();
		for(int i=0; i<operations.length; i++) {
			if(operations[i].startsWith("I")) {  //데이터 삽입
				max_queue.offer(Integer.valueOf(operations[i].substring(2, operations[i].length())));
				min_queue.offer(Integer.valueOf(operations[i].substring(2, operations[i].length())));
			}
			else if(operations[i].startsWith("D")) {
				if(operations[i].contains("-")) {  //최솟값 삭제
					if(!min_queue.isEmpty()) {
						min = min_queue.poll();
						if(!max_queue.isEmpty())
							max_queue.remove(min);
					}
				}
				else {  //최댓값 삭제
					if(!max_queue.isEmpty()) {
						max = max_queue.poll();
						if(!min_queue.isEmpty())
							min_queue.remove(max);
					}
				}
			}
		}
		max = 0;
		min = 0;
		if(!max_queue.isEmpty()) {
			max = max_queue.poll();
		}
		if(!min_queue.isEmpty()){
            min = min_queue.poll();
        }
		System.out.println(max_queue.size() + " , " + min_queue.size());
		System.out.println(max + " , " + min);
	}

}
