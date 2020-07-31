package Èü;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Àý´ñ°ªÈü {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> plus_arr = new PriorityQueue<Integer>();
		PriorityQueue<Integer> minus_arr = new PriorityQueue<Integer>(Comparator.reverseOrder());
		int n = sc.nextInt();
		int m = 0;
		int p = 0;
		for(int i=0; i<n; i++) {
			m=0;
			p=0;
			int a = sc.nextInt();
			if(a<0) {
				minus_arr.add(a);
			}
			else if(a>0) {
				plus_arr.add(a);
			}
			else {
				if(minus_arr.size()!=0) {
					 m = minus_arr.poll();
				}
				if(plus_arr.size()!=0) {
					 p = plus_arr.poll();
				}
				if(m!=0 && p!=0) {
					if(Math.abs(m) > Math.abs(p)) {
						System.out.println(p);
						minus_arr.add(m);
					}
					else {
						System.out.println(m);
						plus_arr.add(p);
					}
				}
				else {
					if(p==0) {
						System.out.println(m);
					}
					else {
						System.out.println(p);
					}
				}
			}
		}
	}

}
