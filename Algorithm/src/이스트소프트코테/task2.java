package �̽�Ʈ����Ʈ����;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class task2 {
	static int answer=-1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {42,33,60};
		
		solution(A);
	}

	public static void solution(int[] A) {
		ArrayList<data> arr = new ArrayList<data>();
		for(int i=0; i<A.length; i++) {
			String s = String.valueOf(A[i]);
			int num = A[i];
			int sum = 0;
			int k = (int) Math.pow(10, s.length()-1);
			for(int j=0; j<s.length(); j++) {
				sum += A[i]/k;
				A[i] -= (A[i]/k)*k;
				k/=10;
			}
			data d = new data(num, sum);
			arr.add(d);
		}
		Collections.sort(arr, new data());
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i).num + " : " + arr.get(i).sum);
		}
		
		int a = arr.get(0).sum;
		//ArrayList<Integer> num_data = new ArrayList<Integer>();
		PriorityQueue<Integer> num_arr = new PriorityQueue<Integer>(Comparator.reverseOrder());
		//num_data.add(arr.get(0).num);
		num_arr.add(arr.get(0).num);
		int flag=0;
		for(int i=1; i<arr.size(); i++) {
			if(a == arr.get(i).sum) {  // �ڸ��� ���� �������� ������ num_data�� �߰�
				//num_data.add(arr.get(i).num);
				num_arr.add(arr.get(i).num);
				flag=1;
			}
			else {  // �ٸ����� ������ a�� �ٲ��ְ� ���� num_data�迭���� ���� ū ���� ����
				if(num_arr.size()<2) { // �ڸ����� �������� 2���� �ȵǸ� num_data�� clear���ְ� �ٽ� ó������ ����
					//num_data.clear();
					//num_data.add(arr.get(i).num);
					num_arr.clear();
					num_arr.add(arr.get(i).num);
					a = arr.get(i).sum;
					continue;
				}
				//Collections.sort(num_data);
				int ans = 0;
				//ans += num_data.get(num_data.size()-1);
				//ans += num_data.get(num_data.size()-2);
				ans += num_arr.poll();
				ans += num_arr.poll();
				if(answer<ans)
					answer = ans;
				//num_data.clear();
				//num_data.add(arr.get(i).num);
				num_arr.clear();
				num_arr.add(arr.get(i).num);
				a = arr.get(i).sum;
				flag=0;
			}
		}
		if(flag==1) {
			if(num_arr.size()>=2) { // �ڸ����� �������� 2���� �ȵǸ� num_data�� clear���ְ� �ٽ� ó������ ����
				//Collections.sort(num_data);
				int ans = 0;
				//ans += num_data.get(num_data.size()-1);
				//ans += num_data.get(num_data.size()-2);
				ans += num_arr.poll();
				ans += num_arr.poll();
				if(answer<ans)
					answer = ans;
			}
		}
		System.out.println(answer);
	}
}

class data implements Comparator<data>{
	int num;
	int sum;
	public data(int num, int sum) {
		this.num = num;
		this.sum = sum;
	}
	public data() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compare(data arg0, data arg1) {
		if(arg0.sum> arg1.sum)
			return 1;
		else
			return -1;
		// TODO Auto-generated method stub
	}
}