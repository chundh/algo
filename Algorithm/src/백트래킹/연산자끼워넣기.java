package 백트래킹;

import java.util.Scanner;

public class 연산자끼워넣기 {
	static int[] num;
	static int[] arr;
	static int[] data;
	static boolean[] check;
	static int max = -1000000000;
	static int min = 1000000000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		num = new int[n];
		for(int i=0; i<n; i++) {
			num[i] = sc.nextInt();
		}
		arr = new int[n-1];
		data = new int[n-1];
		check = new boolean[n-1];
		int cnt=0;
		for(int i=0; i<4; i++) {
			int k = sc.nextInt();
			for(int j=0; j<k; j++) {
				arr[cnt] = i+1;
				cnt++;
			}
		}
		dfs(0,0);
		
		System.out.println(max);
		System.out.println(min);
	}

	public static void dfs(int cnt, int idx) {
		if(cnt == arr.length) {
			int sum=num[0];
			for(int i=0; i<data.length; i++) {
				if(data[i]==1) {  //+
					sum += num[i+1];
				}else if(data[i]==2) { //-
					sum -= num[i+1];
				}else if(data[i]==3) {  //x
					sum *= num[i+1];
				}else {  //%
					if(sum<0 && num[i+1]<0) {
						num[i+1] *= -1;
						sum *= -1;
						sum /= num[i+1];
						num[i+1] *= -1;
						continue;
					}
					if(sum<0) {
						sum *= -1;
						sum /= num[i+1];
						sum *= -1;
						continue;
					}
					if(num[i+1]<0) {
						num[i+1] *= -1;
						sum /= num[i+1];
						sum *= -1;
						num[i+1] *= -1;
						continue;
					}
					sum /= num[i+1];
					
				}
			}
			if(sum>max)
				max = sum;
			if(sum<min)
				min = sum;
			return;
		}
		for(int i=0; i<arr.length; i++) {
			if(!check[i]) {
				data[idx] = arr[i];
				check[i] = true;
				cnt++;
				idx++;
				dfs(cnt,idx);
				check[i] = false;
				cnt--;
				idx--;
				data[idx] = 0;				
			}
		}
		return;
	}
}
