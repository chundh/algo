package Dynamic_Programming;

import java.util.Scanner;

public class น้มุ_1912 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] list = new int[n];
		list[0] = arr[0];
		int max = arr[0];
		for(int i=1; i<n; i++) {
			list[i] = Math.max(list[i-1]+arr[i], arr[i]);
			if(list[i]>max)
				max = list[i];
		}
		System.out.println(max);
	}

}
