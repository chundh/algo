package DFS.BFS;

public class Å¸°Ù³Ñ¹ö {
	static int cnt=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1,1,1,1,1}; 
		int now = 0;
		int index=-1;
		int target = 3;
		DFS(numbers, now, index, target);
		int answer = cnt;
		System.out.println(answer);
	}
	
	public static void DFS(int[] numbers, int now, int index, int target) {
		index++;
		if(index==numbers.length && now==target) {
			cnt++;
			return;
		}
		if(index>=numbers.length)
			return;
		DFS(numbers, now + numbers[index], index, target);
		DFS(numbers, now - numbers[index], index, target);
	}

}
