package 백트래킹;

import java.util.Scanner;

public class 스타트와링크 {
	static int[][] board;
	static int[] arr;
	static boolean[] check;
	static int n;
	static int answer = -1;
	static int sum1=0;
	static int sum2=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		board = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		arr = new int[n];
		check = new boolean[n+1];
		dfs(0);
		System.out.println(answer);
	}
	
	public static void dfs(int cnt) {
		if(cnt==n/2) {
			int flag=0;
			for(int i=1; i<=n; i++) {
				flag=0;
				for(int j=0; j<arr.length/2; j++) {
					if(arr[j]==i) {
						flag=1;
						break;
					}
				}
				if(flag==0) {
					arr[cnt] = i;
					cnt++;
				}
				if(cnt==n)
					break;
			}
			
			int[] arr1 = new int[arr.length/2];
			int[] arr2 = new int[arr.length/2];
			boolean[] check1 = new boolean[arr.length/2];
			boolean[] check2 = new boolean[arr.length/2];
			for(int i=0; i<arr.length/2; i++) {
				arr1[i] = arr[i];
			}
			for(int i=arr.length/2; i<n; i++) {
				arr2[i-arr.length/2] = arr[i];
			}
			int[] new_arr = new int[2];
			sum1=0;
			back_track(arr.length/2,2,0,arr1,check1,new_arr);
			sum2 = sum1;
			sum1=0;
			back_track(arr.length/2,2,0,arr2,check2,new_arr);
			
			int sum = Math.abs(sum1-sum2);
			if(answer==-1)
				answer = sum;
			else if(answer>sum)
				answer = sum;
			return;
		}
		for(int i=1; i<n+1; i++) {
			if(!check[i]) {
				if(cnt!=0 && i<=arr[cnt-1])
					continue;
				arr[cnt] = i;
				check[i] = true;
				cnt++;
				dfs(cnt);
				cnt--;
				check[i] = false;
				arr[cnt] = 0;
			}
		}
		
	}
	public static void back_track(int n, int m, int cnt, int[] arr, boolean[] check, int[] new_arr) {
		if(cnt==m) {
			for(int i=0; i<new_arr.length-1; i++) {
				sum1 += board[new_arr[i]-1][new_arr[i+1]-1] + board[new_arr[i+1]-1][new_arr[i]-1];
			}
			return;
		}
		for(int i=0; i<n; i++) {
			if(!check[i]) {
				if(cnt!=0 && arr[i]<new_arr[cnt-1])
					continue;
				check[i] = true;
				new_arr[cnt] = arr[i];
				cnt++;
				back_track(n,m,cnt,arr,check,new_arr);
				check[i] = false;
				cnt--;
			}
		}
	}

}
