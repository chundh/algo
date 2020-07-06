package Dynamic_Programming;

import java.util.Scanner;

public class น้มุ_1003 {

	static int[] cnt0;
	static int[] cnt1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		cnt0 = new int[41];
		cnt1 = new int[41];
		cnt0[0] = 1;
		cnt1[0] = 0;
		cnt1[1] = 0;
		cnt1[1] = 1;
		for(int i=2; i<=40; i++) {
			cnt0[i] = -1;
			cnt1[i] = -1;
		}
		
		for(int i=0; i<n; i++) {
			int k = sc.nextInt();
			if(cnt0[k]!=-1) {
				System.out.println(cnt0[k] + " , " + cnt1[k] + "---");
				continue;
			}
			for(int j=2; j<=k; j++) {
				cnt0[j] = cnt0[j-1] + cnt0[j-2];
				cnt1[j] = cnt1[j-1] + cnt1[j-2];
			}
			System.out.println(cnt0[k] + " , " + cnt1[k]);
		}
	}

}
