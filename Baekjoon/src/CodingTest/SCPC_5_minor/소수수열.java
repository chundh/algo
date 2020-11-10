package CodingTest.SCPC_5_minor;

import java.util.Scanner;

public class 소수수열 {
	static int max_a=0;
	static int max_b=0;
	static int[] arr = new int[30001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		소수수열.getChe(30000);
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			int answer=-1;
			int a = sc.nextInt();
			int b = sc.nextInt();
			solution(a, 0, 'a');
			solution(b, 0, 'b');
			if(max_a>max_b)
				answer = 1;
			else if(max_a<max_b)
				answer = 2;
			else
				answer = 3;

			max_a = 0;
			max_b = 0;
			System.out.println("Case #"+(test_case+1));
			System.out.println(answer);
		}
	}
	
	public static void getChe(int num) {

	    //int[] arr = new int[num];

	    int i = 2;
	    // 입력받은 수 만큼 배열에 모두 초기화 해둔다
	    for (i = 2; i <= num; i++) {
	        arr[i] = i;
	    }
	    for (i = 2; i <= num; i++) {  // 이미 체크된 수의 배수는 확인하지 않는다
	    	if(arr[i]==0)
	            continue;
	        for (int j = i + i; j <= num; j += i) { // i를 제외한 i의 배수들은 0으로 체크
	            arr[j] = 0;
	        }
	    }
	    // print
	    /*
	    for (i = 2; i < num; i++) {
	        if (arr[i] != 0) {
	            System.out.print(arr[i] + " ");
	        }
	    }
	    */
	}
	
	public static void solution(int k, int cnt, char c) {
		//소수 판별
		if(k<=0)
			return;
		if(arr[k] != 0) {
			cnt++;
		}
		if(k<10) {
			//System.out.println(c + " : " + k + " , " + cnt);
			if(c=='a') {
				if(cnt>max_a)
					max_a = cnt;
			}
			else {
				if(cnt>max_b)
					max_b = cnt;
			}
			return;
		}
		
		for(int digit = 1; k % digit != k; digit *= 10) {
			int tmp = k / (digit * 10);
			tmp *= digit;
			tmp += k % digit;
			solution(tmp, cnt, c);
			if(arr[tmp] != 0) {
				cnt--;
			}
		}
	}
	
}
