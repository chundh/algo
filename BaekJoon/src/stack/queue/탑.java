package stack.queue;

public class ž {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = {1,5,3,6,7,6,5};
		int[] answer = new int[heights.length];
		int flag=0;
		for(int i=heights.length-1; i>=0; i--) {
			for(int j=i-1; j>=0; j--) {
				if(heights[i]<heights[j]) {
					answer[i] = j+1;
					flag=1;
					break;
				}
			}
			if(flag==0) {
				answer[i] = 0;
			}
		}
		
		for(int i=0; i<heights.length; i++) {
			System.out.println(answer[i]);
		}
	}

}
