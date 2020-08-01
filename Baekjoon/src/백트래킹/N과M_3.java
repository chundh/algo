package 백트래킹;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
 3 2하면
 1 1 
 1 2 
 1 3 
 2 1 
 2 2 
 2 3 
 3 1 
 3 2 
 3 3 
 */

public class N과M_3 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[m];
		boolean[] check = new boolean[n+1];
		back_track(n,m,0,arr,check);
		bw.flush();
	}
	
	public static void back_track(int n, int m, int cnt, int[] arr, boolean[] check) throws IOException {
		if(cnt==m) {
			for(int i=0; i<arr.length; i++) {
				bw.write(Integer.toString(arr[i]) + " ");
			}
			bw.newLine();
			return;
		}
		for(int i=1; i<=n; i++) {
			if(!check[i]) {
				//check[i] = true;
				arr[cnt] = i;
				cnt++;
				back_track(n,m,cnt,arr,check);
				check[i] = false;
				cnt--;
			}
		}
	}

}
