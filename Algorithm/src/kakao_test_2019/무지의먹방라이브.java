package kakao_test_2019;

public class 무지의먹방라이브 {
	public static void main(String args[]) {
		int[] food_times = {3,1,2};
		long k = 5;
		solution(food_times, k);
	}
	
	public static void solution(int[] food_times, long k) {
		long time=0;
		int index=0;
		while(true) {
			if(food_times[index]==0) { // 해당 음식을 다먹었으면 다음배열로 이동
				index++;
				if(index==food_times.length) //마지막 음식인 경우 0번으로 이동
					index=0;
			}
			else {
				food_times[index]--;
				index++;
				if(index==food_times.length)
					index=0;
				time++;
				if(time==k)
					break;
			}
		}
		int cnt=0;
		while(true) {
			if(food_times[index]!=0) {
				break;
			}
			index++;
			if(index==food_times.length)
				index=0;
			cnt++;
			if(cnt==food_times.length) {
				System.out.println("먹을 음식이 없음");				
				break;	
			}
		}
		index++;
		if(cnt==food_times.length) {
			System.out.println("먹을 음식이 없음");		
		}
		else {
			System.out.println("먹을 음식은 : " + index + "번째 음식");
		}
		
	}
}
