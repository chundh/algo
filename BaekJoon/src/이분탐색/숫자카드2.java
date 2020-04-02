package 이분탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 숫자카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[20000001];
		for(int i=0; i<n; i++) {
			int a = sc.nextInt();
			arr[a+10000000]++;
		}
		int m = sc.nextInt();
		int[] data = new int[m];
		for(int i=0; i<m; i++) {
			data[i] = sc.nextInt()+10000000;
		}
		for(int i=0; i<m; i++) {
			System.out.println(arr[data[i]]);
		}
	}
}
