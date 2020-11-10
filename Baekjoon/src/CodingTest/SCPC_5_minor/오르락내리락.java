package CodingTest.SCPC_5_minor;

import java.util.Scanner;
//5. 6 3 4 2 1 -> 5
public class 오르락내리락 {
	static int[] arr = new int[1000001];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 3;
		for(int i=4; i<1000000; i++) {
			if(i%2==0) {
				if(arr[i/2] != 0) {
					arr[i] = arr[i/2] + 1;
				}
			}
			else {
				if(arr[(i+1)/2] != 0) {
					arr[i] = arr[((i+1)/2)] + 2;
				}
			}
		}
		
		for(int test_case = 0; test_case < T; test_case++) {
			int answer=0;
			int start = sc.nextInt();
			int end = sc.nextInt();
			for(int i=start; i<=end; i++) {
				answer+=arr[i];
			}
			System.out.println("Case #"+(test_case+1));
			System.out.println(answer);
		}
	}
	
	
	
	/*
	static int[] arr = new int[100001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			int answer = 0;
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			for(int j=n1; j<=n2; j++) {
				if(arr[j]!=0) {
					answer += arr[j];
				}
				else {
					int cnt = solution(j, 0);
					answer += cnt;
					arr[j] = cnt;
				}
			}
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(answer);
		}
	}
	
	public static int solution(int k, int cnt) {
		if(arr[k]!=0) {
			return arr[k]+cnt;
		}
		if(k==1) {
			return cnt;
		}
		else if(k%2==1) {
			k++;
			cnt++;
			int a = solution(k, cnt);
			return a;
		}
		k/=2;
		cnt++;
		int a = solution(k, cnt);
		return a;
	}
	*/
}
