package ��;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ������ {

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
			System.out.println("���� : " + date + "��, �а��� : " + stock);
			if(date==k)
				break;
			if(i<dates.length) {
				if(date == dates[i]) {
					System.out.println(date + "�Ͽ� �����Ҽ� �ִ� �а��� " + supplies[i] + "�߰�");
					queue.add(supplies[i]);
					i++;
				}
			}
			if(stock==0) {
				int max = queue.poll();
				System.out.println(date + "�Ͽ� �а��� " + max + "�߰�");
				stock += max;
				answer++;
			}
			date++;
			stock--;
		}
		System.out.println(answer);
	}

}
