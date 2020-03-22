package 백트래킹;

import java.util.Scanner;
/*
3 2 치면
1 2
1 3
2 3
*/
public class N과M_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[m];
		boolean[] check = new boolean[n+1];
		back_track(n,m,0,arr,check);
	}
	
	public static void back_track(int n, int m, int cnt, int[] arr, boolean[] check) {
		if(cnt==m) {
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i=1; i<=n; i++) {
			if(!check[i]) {
				if(cnt!=0 && i<=arr[cnt-1])
					continue;
				check[i] = true;
				arr[cnt] = i;
				cnt++;
				back_track(n,m,cnt,arr,check);
				check[i] = false;
				cnt--;
			}
		}
	}

}
