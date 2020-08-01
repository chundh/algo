package stack.queue;

public class 주식가격 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1,2,3,2,3};
		int[] answer = new int[prices.length];
		int time=0;
		
		for(int i=0; i<prices.length; i++) {
			time = 0;
			if(i==prices.length-1) {
				answer[i] = time;
				break;
			}
			else {
				for(int j=i+1; j<prices.length; j++) {
					time++;
					if(j==prices.length-1) {
						answer[i] = time;
						break;
					}
					if(prices[i]>prices[j]) {
						answer[i] = time;
						break;
					}
				}
			}
		}
		for(int i=0; i<prices.length; i++) {
			System.out.println(answer[i]);
		}
	}

}
