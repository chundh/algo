package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class �ܼ�ī�޶� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] routes = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
		solution(routes);
	}
	
	public static void solution(int[][] routes) {
		Arrays.sort(routes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]>o2[0])
					return 1;
				else
					return -1;
			}
		});
		ArrayList<route_data> arr = new ArrayList<route_data>();
		for(int i=0; i<routes.length; i++) { // ���� ��谪(min, max)�� �������� ���� ������ ���� min~max �ۿ� ���´ٸ� ������ �ʿ� ����. 
			int start = routes[i][0];
			int end = routes[i][1];
			route_data dt = new route_data(start, end);
			if(arr.size()==0) {
				arr.add(dt);
				continue;
			}
			int flag=0;
			for(int j=0; j<arr.size(); j++) {
				if(arr.get(j).start<=start && arr.get(j).end>=start){
					if(start==arr.get(j).end) {
						start = arr.get(j).start;
					}
					dt = new route_data(start, arr.get(j).end);
					arr.set(j, dt);
					flag=1;
				}
				if(arr.get(j).end>=end && arr.get(j).start<=end) {
					dt = new route_data(arr.get(j).start, end);
					arr.set(j, dt);
					flag=1;
				}
				if(flag==1)
					break;
				if(end<arr.get(j).start)
					flag=2;
				if(start>arr.get(j).end)
					flag=2;
				if(start<arr.get(j).start && end>arr.get(j).end) {
					flag = 3;
					break;
				}
			}
			if(flag==2)
				arr.add(dt);
		}
		
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i).start + " , " + arr.get(i).end);
		}
		System.out.println(arr.size());
		
	}
}

class route_data{
	int start;
	int end;
	public route_data(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
