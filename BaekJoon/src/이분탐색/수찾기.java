package 이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 수찾기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
			
		}
		int m = sc.nextInt();
		int[] data = new int[m];
		for(int i=0; i<m; i++) {
			data[i] = sc.nextInt();
		}
		Arrays.sort(a);
		for(int i=0; i<m; i++) {
			int ans = search(0,a.length,a,data[i]);
			System.out.println(ans);
		}
	}

	public static int search(int start, int end, int[] a, int data) {
		int mid = (start+end)/2;
		if(start>end || mid>=a.length)
			return 0;
		if(a[mid] == data) {
			return 1;
		}
		if(a[mid]<data) {
			return search(mid+1,end,a,data);
		}else if(a[mid]>data) {
			return search(start,mid-1,a,data);
		}
		return 0;
			
	}
}
