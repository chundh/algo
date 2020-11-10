package CodingTest.카카오겨울인턴십;

public class 징검다리건너기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		
		solution(stones, k);
	}
	
	public static void solution(int[] stones, int k) {
		int flag=0;
		int answer = 0;
		while(true) {
			int dis = 1;
			for(int i=0; i<stones.length; i++) {
				if(stones[i] == 0) {
					dis++;
					if(dis>k) {
						flag=1;
						break;
					}
				}
				else {
					stones[i]--;
					dis=1;
				}
			}
			if(flag==1)
				break;
			answer++;
		}
		System.out.println(answer);
	}

}
