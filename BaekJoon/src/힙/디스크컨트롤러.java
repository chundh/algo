package ��;

import java.util.ArrayList;
import java.util.PriorityQueue;
//������ Ǭ �ٸ� �ش��� �� ��� �� ������ ������ ����. ���� �ð����� ������ ª�� �۾��� �ؾ��ϴµ� �۾� �غ�Ϸ�ð��� ���� �۾��� �����ؾ� 100���� ����
public class ��ũ��Ʈ�ѷ� {

	public static class jobs implements Comparable<jobs>{
		int start;
		int end;
		public jobs(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(jobs target) {
			if (this.start > target.start) {
	            return 1;
	        } else if (this.start < target.start) {
	            return -1;
	        } else if(this.start == target.start) {
	        	if(this.end > target.end)
	        		return 1;
	        	else
	        		return -1;
	        }
	        return 0;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] jobs = {{0,9},{0,4},{0,5},{0,7},{0,3}};
		
		ArrayList<Integer> times = new ArrayList<Integer>();
		int time=0;
		int min=5000001;
		int index=-1;
		int sum = 0;
		PriorityQueue<jobs> queue = new PriorityQueue<jobs>();
		
		for(int i=0; i<jobs.length; i++) {
			jobs job = new jobs(jobs[i][0], jobs[i][1]);
			queue.offer(job);
		}
		ArrayList<jobs> arr = new ArrayList<jobs>();
		//���� �ð����� ������ �� �ִ� �۾��߿��� ���� �ҿ�ð��� ���� �۾����� queue���� ������. �ƹ��͵� ���� ���� ���� �ð����κ��� ���� ���۽ð��� ���� �۾��� queue���� ����.
		
		while(!queue.isEmpty()) {
			min = 5000001;
			index = -1;
			if(time==0) {  //�ð��� 0�϶����� ó���� ���� �۾��� ���� ����. ���� �������� ������ ������ �ҿ�ð��� ª������ ������ �����ϰ� ����.
				jobs job = queue.poll();
				time += job.end;
				times.add(time);
				//System.out.println(job.start + " , " + job.end + " : �۾��� ����");
			}
			else {
				jobs data = queue.poll();
				if(data.start>time) { //���� �۾��� ���� �ð����� ���� �Ұ����� ��
					time = data.start;
				}
				queue.offer(data);
				while(!queue.isEmpty()) {  //���� ������ �� �ִ� �۾����� arr�� ����.
					jobs job = queue.poll();
					if(job.start>time) {
						queue.offer(job);
						break;
					}
					//System.out.println("arr�� " + job.start + " , " + job.end + "�߰�");
					arr.add(job);
				}
				for(int i=0; i<arr.size(); i++) {  //arr�� ����� �� �� �ҿ�ð��� ���� ª�� ���� ã�Ƽ� times�迭�� �����͸� �ְ� arr�� �ʱ�ȭ.
					if(arr.get(i).end<min) {
						if(index != -1) {
							queue.offer(arr.get(index));
						}
						min = arr.get(i).end;
						index = i;
					}
					else {
						queue.offer(arr.get(i));
					}
				}
				time += arr.get(index).end;
				times.add(time-arr.get(index).start);
				//System.out.println(arr.get(index).start + " , " + arr.get(index).end + " : �۾��� ����");
				arr.clear();
			}
		}
		
		for(int i=0; i<times.size(); i++) {
			System.out.println(times.get(i));
			sum += times.get(i);
		}
		
		
		int answer = sum/jobs.length;
		System.out.println("ans : " + answer);
	}

}
