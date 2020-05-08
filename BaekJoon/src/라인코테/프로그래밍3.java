package 라인코테;

public class 프로그래밍3 {
	static int answer=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String road = "111011110011111011111100011111";
		int n = 3;
		solution(road, n);
	}

	public static void solution(String road, int n) {
		int cnt=0;
		for(int i=0; i<road.length(); i++) {
			if(road.charAt(i)=='0')
				cnt++;
		}
		if(cnt<=n)
			answer = road.length();
		else {
			check(road, n);
		}
		
		System.out.println(answer);
	}
	
	public static void check(String road, int n) {
		if(n==0) {
			int max_cnt=0;
			int cnt=0;
			for(int i=0; i<road.length(); i++) {
				if(road.charAt(i)=='1') {
					cnt++;
				}
				else {
					if(max_cnt<cnt)
						max_cnt=cnt;
					cnt=0;
				}
			}
			if(answer < max_cnt) {
				answer = max_cnt;
				return;
			}
		}
		for(int i=0; i<road.length(); i++) {
			if(road.charAt(i)=='0') {
				String road_data = road;
				road = road.substring(0,i) + "1" + road.substring(i+1, road.length());
				n--;
				check(road, n);
				n++;
				road = road_data;
			}
		}
	}
	
}
