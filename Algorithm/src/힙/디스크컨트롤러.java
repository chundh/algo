package 힙;

import java.util.ArrayList;
import java.util.PriorityQueue;
//문제를 푼 다른 해답을 본 결과 이 문제에 에러가 있음. 현재 시간에서 가능한 짧은 작업을 해야하는데 작업 준비완료시간이 빠른 작업을 진행해야 100점이 나옴
public class 디스크컨트롤러 {

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
		//현재 시간에서 수행할 수 있는 작업중에서 가장 소요시간이 작은 작업부터 queue에서 빼낸다. 아무것도 없을 때는 현재 시간으로부터 가장 시작시간이 빠른 작업을 queue에서 뺀다.
		
		while(!queue.isEmpty()) {
			min = 5000001;
			index = -1;
			if(time==0) {  //시간이 0일때에는 처음에 들어온 작업을 먼저 수행. 정렬 과정에서 시작이 같으면 소요시간이 짧은것을 앞으로 정렬하게 만듦.
				jobs job = queue.poll();
				time += job.end;
				times.add(time);
				//System.out.println(job.start + " , " + job.end + " : 작업을 진행");
			}
			else {
				jobs data = queue.poll();
				if(data.start>time) { //남은 작업이 현재 시간에서 수행 불가능할 떄
					time = data.start;
				}
				queue.offer(data);
				while(!queue.isEmpty()) {  //현재 실행할 수 있는 작업들을 arr에 저장.
					jobs job = queue.poll();
					if(job.start>time) {
						queue.offer(job);
						break;
					}
					//System.out.println("arr에 " + job.start + " , " + job.end + "추가");
					arr.add(job);
				}
				for(int i=0; i<arr.size(); i++) {  //arr에 저장된 것 중 소요시간이 가장 짧은 것을 찾아서 times배열에 데이터를 넣고 arr은 초기화.
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
				//System.out.println(arr.get(index).start + " , " + arr.get(index).end + " : 작업을 진행");
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
