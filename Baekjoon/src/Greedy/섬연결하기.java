package Greedy;

import java.util.PriorityQueue;

//�׸��� + ũ�罺Į �˰��� Ȱ���ϴ� ����

public class �������ϱ� {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		
		solution(n, costs);
	}

	public static void solution(int n, int[][] costs) {
		PriorityQueue<island_data> queue = new PriorityQueue<island_data>(); // �켱���� ť�� ����Ͽ� ��� ������ �迭 ����
		int answer=0;
		int[] parent = new int[n];
		for(int i=0; i<n; i++) {
			parent[i] = i;
		}
		for(int i=0; i<costs.length; i++) {
			int start = costs[i][0];
			int end = costs[i][1];
			int money = costs[i][2];
			island_data id = new island_data(start, end, money);
			queue.offer(id);
		}
		Connect ct = new Connect();
		int len = queue.size();
		for(int i=0; i<len; i++) {
			island_data id = queue.poll();
			if(!ct.findParent(parent, id.node[0], id.node[1])){ // �θ� ���� ���� ���� ���� ����Ǿ����� ���� ����̹Ƿ� �����ؾ��Ѵ�.
				answer+=id.money;
				ct.unionParent(parent, id.node[0], id.node[1]); // ��尣 �θ� ����
			}
		}
		System.out.println(answer);
	}
}

class island_data implements Comparable<island_data>{
	int money;
	int[] node;
	public island_data(int start, int end, int money) {
		this.node = new int[2];
		this.node[0] = start;
		this.node[1] = end;
		this.money = money;
	}
	@Override
	public int compareTo(island_data arg0) {
		// TODO Auto-generated method stub
		if(this.money>arg0.money)
			return 1;
		else return -1;
	}
}

class Connect{
	int getParent(int[] parent, int x) { // �ֻ��� �θ�� �ڱ� �ڽ��� �θ��̹Ƿ� parent[x] = x�� �� ���� ����.
		if(parent[x] == x)
			return x;
		else
			return getParent(parent, parent[x]); // �ڱ� �ڽ��� �θ��� ������ ���
	}
	
	void unionParent(int[] parent, int a, int b) { // �θ��� ���� ���� ������ ����
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a<b)
			parent[b] = a;
		else
			parent[a] = b;
	}
	
	boolean findParent(int[] parent, int a, int b) { // �θ� ã�Ƽ� ������ true, �ٸ��� false ����
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a==b)
			return true;
		else
			return false;
	}
}

// ���� : https://blog.naver.com/world9604/222001631793