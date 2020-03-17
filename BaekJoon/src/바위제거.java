import java.util.ArrayList;
import java.util.Arrays;

public class 바위제거 {

	static long answer = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long distance = 25;
		int[] rocks = {2, 14, 11, 21, 17};
		int n = 2;
		
		solution(distance, rocks, n);
	}
	static void combination(int[] arr, boolean[] visited, int start, int n, int r, int[] rocks, long distance, int choice) {
	    if(r == 0) {
	        print(arr, visited, n, r, rocks, distance, choice);
	        return;
	    } else {
	        for(int i=start; i<n; i++) {
	            visited[i] = true;
	            combination(arr, visited, i + 1, n, r - 1, rocks, distance, choice);
	            visited[i] = false;
	        }
	    }
	}
	static void print(int[] arr, boolean[] visited, int n, int r, int[] rocks, long distance, int choice) {
		ArrayList<Integer> data = new ArrayList<Integer>();
        for(int i=0; i<n; i++) {
            if(visited[i] == true) {
                data.add(arr[i]);
            }
        }
        remove(rocks, data, choice, distance);
    }

	
	public static void solution(long distance, int[] rocks, int n) {
		Arrays.sort(rocks);
		boolean[] visited = new boolean[rocks.length];
		combination(rocks, visited, 0, rocks.length, n, rocks, distance, n);
		System.out.println(answer);
	}
	
	public static void remove(int[] rocks, ArrayList<Integer> data, int n, long distance) {
		long[] arr = new long[rocks.length-n+2];
		int index=0;
		ArrayList<Long> num = new ArrayList<Long>();
		
		for(int i=1; i<rocks.length; i++) {
			if(!data.contains(rocks[i])) {
				num.add((long) (rocks[i] - rocks[index]));
				index++;
			}
		}
		long min = distance;
		for(int i=0; i<num.size(); i++) {
			System.out.print(num.get(i) + " ");
			if(num.get(i)<min) {
				min = num.get(i);
			}
		}
		System.out.println();
		if(answer < min)
			answer = min;
	}

}
