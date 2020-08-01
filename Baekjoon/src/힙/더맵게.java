package Èü;

import java.util.PriorityQueue;

public class ´õ¸Ê°Ô {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scoville = {0,0,1};
		int K = 4;
		PriorityQueue<Integer> arr = new PriorityQueue<Integer>();
		int answer=0;
		for(int i=0; i<scoville.length; i++) {
			arr.add(scoville[i]);
		}
		int min1 = 0;
		while(true) {
			min1 = arr.peek();
			if(min1>= K)
				break;
			if(arr.size()<2) {
				answer=-1;
				break;
			}
			answer++;
			arr.remove(min1);
			int min2 = arr.peek();
			arr.remove(min2);
			if(min1==0 && min2==0) {
				answer=-1;
				break;
			}
			System.out.println(min1 + " , " + min2);
			int num = min1 + min2*2;
			arr.add(num);
			
		}
		System.out.println("answer" + answer);
	}

}
