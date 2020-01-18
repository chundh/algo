package stack.queue;

import java.util.LinkedList;
import java.util.Queue;
public class «¡∏∞≈Õ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] priorities = {3,3,4,2};
		int location = 3;
		int answer = location;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i<priorities.length; i++) {
			queue.offer(priorities[i]);
		}
		int max=0;
		int index=0;
		int data = 0;
		int cnt=0;
		for(int i=0; i<priorities.length; i++) {
			max=0;
			index=0;
			for(int j=0; j<queue.size(); j++) {
				data = queue.poll();
				if(data>max) {
					max=data;
					index = j;
				}
				queue.offer(data);
			}
			for(int j=0; j<index; j++) {
				if(answer==0) {
					answer = queue.size()-1;
				}
				else
					answer--;
				data = queue.poll();
				queue.offer(data);
			}
			data = queue.poll();
			System.out.println(data + " , " + answer);
			cnt++;
			answer--;
			if(answer==-1) {
				System.out.println(cnt);
				answer=cnt;
				break;
			}
		}
	}
}
