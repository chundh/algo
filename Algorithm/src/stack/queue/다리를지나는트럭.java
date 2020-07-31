package stack.queue;

public class 다리를지나는트럭 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		int[] truck_time = new int[truck_weights.length];
		int cnt=0;
		int answer=0;
		int now_weight=0;
		int first_index=0;
		int last_index=0;
		while(true) {
			answer++;
			if(cnt==truck_weights.length) {
				break;
			}
			if(last_index<truck_weights.length) {
				if(now_weight + truck_weights[last_index] <= weight) {
					now_weight += truck_weights[last_index];
					last_index++;
				}
			}
			for(int i=first_index; i<last_index; i++) {
				truck_time[i]++;
				if(truck_time[i]==bridge_length) { //트럭이 다리 끝에 도착
					first_index++;
					cnt++;
					now_weight -= truck_weights[i];
				}
			}		
		}
		System.out.println(answer);
	}

}
