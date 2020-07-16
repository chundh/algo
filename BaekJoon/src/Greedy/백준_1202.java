package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class น้มุ_1202 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long answer=0;
		int[] bag = new int[k];
		data[] dt = new data[n];
		PriorityQueue<Integer> arr = new PriorityQueue<Integer>(Comparator.reverseOrder());
		for(int i=0; i<n; i++) {
			int m = sc.nextInt();
			int v = sc.nextInt();
			data d = new data(m,v);
			dt[i] = d;
		}
		for(int i=0; i<k; i++) {
			int c = sc.nextInt();
			bag[i] = c;
		}
		Arrays.sort(bag);
		Arrays.sort(dt);
		
		int j=0;
		for(int i=0; i<k; i++) {
			while(j<n && bag[i]>=dt[j].m) {
				arr.add(dt[j].v);
				j++;
			}
			if(!arr.isEmpty())
				answer+=arr.poll();
		}
		
		System.out.println(answer);
	}

}

class data implements Comparable<data>{
	int m;
	int v;
	
	public data(int m, int v) {
		this.m = m;
		this.v = v;
	}

	@Override
	public int compareTo(data arg0) {
		// TODO Auto-generated method stub
		if(this.m>arg0.m)return 1;
		else
			return -1;
	}
}