package Èü;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ÃÖ´ëÈü {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> arr = new PriorityQueue<Integer>(Comparator.reverseOrder());
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			int a = sc.nextInt();
			if(a!=0) {
				arr.add(a);
			}
			else {
				if(arr.size()==0)
					System.out.println("0");
				else {
					System.out.println(arr.poll());
				}
			}
		}
		for(int i=0; i<n; i++) {
			System.out.println(arr.poll());
		}
	}

}
