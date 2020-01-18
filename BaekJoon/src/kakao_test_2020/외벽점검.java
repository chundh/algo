package kakao_test_2020;


//모든지점에서 시계방향으로 탐색을 해서 한번에 점검할 수 있는 지점이 가장 많은 지점을 시작점으로 정한다. 이때 탐색은 dist가 가장 긴 사람부터 탐색. 

public class 외벽점검 {
	static int answer=0;
	static int flag=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 12;
		int[] weak = {1, 5, 6, 10};
		int[] dist = {1, 2, 3, 4};
		int[] check = new int[weak.length];
		int index = dist.length-1;
		solution(weak, dist, check, index, n);
		
		System.out.println(answer);
	}
	
	public static void solution(int[] weak, int[] dist, int[] check, int index, int n) {
		int max=0; //갈수 있는 지점이 가장 많을때의 지점 수 
		int spot=0; // max값일때의 지점의 index값
		int len = 0; // 이동거리를 저장
		int cur = 0; // 이동 가능 지점수를 저장
		for(int i=0; i<weak.length; i++) { // 임의로 출발점을 지정
			int j=i;
			spot = 0;
			len = 0;
			if(weak[i] == -1)
				continue;
			while(true) {
				if(len>dist[index])  //이동거리가 이동가능한 거리를 넘어선 경우.
					break;
				if(j==weak.length-1) {
					if(weak[j] + len > n) {
						if(weak[j] + len - n == weak[0]) {
							cur++;
							j = 0;
						}
					}
					else if(weak[j] + len == weak[0]) {
						cur++;
						j = 0;
					}
				}
				else if(weak[j] + len > n) {
					if(weak[j] + len - n == weak[j+1]) {
						cur++;
						j++;
					}
				}
				else if(weak[j] + len == weak[j+1]) {
					cur++;
					j++;
				} 
				
				len++;
			}
			if(max==cur) {
				
			}
			if(max < cur) {
				spot = i;
				max = cur;
			}
			index--;
		}
		System.out.println(weak[spot] + "부터 " + max + "개의 지점을 점검 가능");
		for(int i=0; i<max; i++) {
			check[spot] = 1;
			spot++; 
			weak[spot] = -1;
		}
		
		answer++;
	}
}
