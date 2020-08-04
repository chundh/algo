package Greedy;

import java.util.PriorityQueue;

//그리디 + 크루스칼 알고리즘 활용하는 문제

public class 섬연결하기 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		
		solution(n, costs);
	}

	public static void solution(int n, int[][] costs) {
		PriorityQueue<island_data> queue = new PriorityQueue<island_data>(); // 우선순위 큐를 사용하여 비용 순으로 배열 정렬
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
			if(!ct.findParent(parent, id.node[0], id.node[1])){ // 부모가 같지 않은 노드는 서로 연결되어있지 않은 노드이므로 연결해야한다.
				answer+=id.money;
				ct.unionParent(parent, id.node[0], id.node[1]); // 노드간 부모 연결
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
	int getParent(int[] parent, int x) { // 최상위 부모는 자기 자신이 부모이므로 parent[x] = x일 때 조건 성립.
		if(parent[x] == x)
			return x;
		else
			return getParent(parent, parent[x]); // 자기 자신이 부모일 때까지 재귀
	}
	
	void unionParent(int[] parent, int a, int b) { // 부모의 수를 작은 것으로 병합
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a<b)
			parent[b] = a;
		else
			parent[a] = b;
	}
	
	boolean findParent(int[] parent, int a, int b) { // 부모를 찾아서 같으면 true, 다르면 false 리턴
		a = getParent(parent, a);
		b = getParent(parent, b);
		if(a==b)
			return true;
		else
			return false;
	}
}

// 참고 : https://blog.naver.com/world9604/222001631793