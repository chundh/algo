package 힙;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 라면공장 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stock = 4;
		int[] dates = {4,10,15};
		int[] supplies = {20,5,10};
		int k = 30;
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		int date=0;
		int i=0;
		int answer=0;
		while(true) {
			System.out.println("현재 : " + date + "일, 밀가루 : " + stock);
			if(date==k)
				break;
			if(i<dates.length) {
				if(date == dates[i]) {
					System.out.println(date + "일에 공급할수 있는 밀가루 " + supplies[i] + "추가");
					queue.add(supplies[i]);
					i++;
				}
			}
			if(stock==0) {
				int max = queue.poll();
				System.out.println(date + "일에 밀가루 " + max + "추가");
				stock += max;
				answer++;
			}
			date++;
			stock--;
		}
		System.out.println(answer);
	}

}
