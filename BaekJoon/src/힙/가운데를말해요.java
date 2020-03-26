package 赛;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 啊款单甫富秦夸 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> arr = new PriorityQueue<Integer>();
		ArrayList<Integer> rec = new ArrayList<Integer>();
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			int a = sc.nextInt();
			arr.add(a);
			int data =0;
			int len = arr.size();
			rec.clear();
			if(len%2 == 0) {
				for(int j=0; j<len/2; j++) {
					data = arr.poll();
					rec.add(data);
				}
			}
			else if(len%2 == 1){
				for(int j=0; j<=len/2; j++) {
					data = arr.poll();
					rec.add(data);
				}
			}
			System.out.println(data);
			for(int j=0; j<rec.size(); j++)
				arr.add(rec.get(j));
			
		}
	}

}
