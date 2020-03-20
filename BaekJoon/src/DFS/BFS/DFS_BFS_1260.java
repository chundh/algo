package DFS.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DFS_BFS_1260 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		boolean[] check = new boolean[n+1];
		ArrayList<Integer>[] list = (ArrayList<Integer>[]) new ArrayList[n+1];
		for(int i=0; i<n+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			list[x].add(y);
			list[y].add(x);
		}
		for(int i=1; i<n+1; i++) {
			Collections.sort(list[i]);
		}
		System.out.print(v + " ");
		DFS(list, check, v);
		System.out.println();
		ArrayList<Integer> stack = new ArrayList<Integer>();
		check = new boolean[n+1];
		BFS(list, check, v, stack);
	}

	public static void DFS(ArrayList<Integer>[] list, boolean[] check, int v) {
		if(check[v]) {
			return;
		}
		check[v] = true;
		
		for(int i=0; i<list[v].size(); i++) {
			if(!check[list[v].get(i)]) {
				System.out.print(list[v].get(i) + " ");
				DFS(list,check,list[v].get(i));
			}
		}
	}
	
	public static void BFS(ArrayList<Integer>[] list, boolean[] check, int v, ArrayList<Integer> stack) {
		if(check[v]) {
			return;
		}
		check[v] = true;
		System.out.print(v + " ");
		for(int i=0; i<list[v].size(); i++) {
			if(!check[list[v].get(i)]) {
				stack.add(list[v].get(i));
			}
		}
		if(stack.size()==0)
			return;
		v = stack.get(0);
		stack.remove(stack.get(0));
		BFS(list, check, v, stack);
	}
}


/*
//DFS 인접리스트
	public static void dfs(ArrayList<Integer>[] a, boolean[] c, int v) {

		if (c[v]) {
			return;
		}
		
		c[v] = true;
		System.out.print(v + " ");

		for (int vv : a[v]) {

			if (!c[vv]) {
				dfs(a, c, vv);
			}

		}

	}

	// BFS 인접리스트
	public static void bfs(ArrayList<Integer>[] a, boolean[] c, int v) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(v);
		c[v] = true;
		
		while(!q.isEmpty()) {
			v = q.poll();
			System.out.print(v + " ");
			
			for (int vv : a[v]) {

				if (!c[vv]) {
					q.add(vv);
					c[vv] = true;
				}

			}
			
		}
		
	}
*/