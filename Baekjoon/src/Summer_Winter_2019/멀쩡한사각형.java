package Summer_Winter_2019;

public class 멀쩡한사각형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long w = 8;
		long h = 12;
		
		solution(w,h);
	}

	public static void solution(long w, long h) {
		long answer = 0;
		long min = (long)h;
		long max = (long)w;
		if (w < h) {
			min = (long)w;
			max = (long)h;
		}

		long value = 1;
		while (value > 0) {
			value = max % min;
			max = min;
			min = value;
		}

		answer = (long)w * (long)h - ((long)w + (long)h - max);
//		return answer;
	}
}
