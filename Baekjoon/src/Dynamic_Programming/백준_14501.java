package Dynamic_Programming;

import java.util.Scanner;

public class น้มุ_14501 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] t = new int[n];
		int[] p = new int[n];
		for(int i=0; i<n; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		int[] list = new int[n];
		int[] money = new int[n];
		list[0] = t[0];
		money[0] = p[0];
		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(list[j]==i && money[j] >= money[i]) {
					if(i+t[i]<=n) {
						list[i] = i + t[i];
						money[i] = money[j] + p[i];
					}
				}
			}
		}
		int answer = -1;
		for(int i=0; i<n; i++) {
			if(money[i]>answer)
				answer = money[i];
		}
		System.out.println(answer);
	}

}
