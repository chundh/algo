package Dynamic_Programming;

import java.util.Scanner;

public class น้มุ_9095 {
	static int answer=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			int k = sc.nextInt();
			sol(k,0);
			System.out.println(answer);
			answer=0;
		}
	}
	public static void sol(int k, int num) {
		if(num==k) {
			answer++;
			return;
		}
		else if(num>k)
			return;
		
		int index = 1;
		while(true) {
			num += index;
			sol(k, num);
			num -= index;
			index++;
			if(index==4)
				return;
		}
	}

}
