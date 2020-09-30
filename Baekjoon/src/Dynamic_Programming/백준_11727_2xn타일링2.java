package Dynamic_Programming;

import java.util.Scanner;

/**
 * dp1 -> 1 1 3 5 5+3*3
 * dp2 -> 0 1 1 3 5
 */

public class 백준_11727_2xn타일링2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];
        dp1[0] = 0;
        dp2[0] = 0;
        dp1[1] = 1;
        dp2[1] = 0;
        if(n>=2) {
            dp1[2] = 1;
            dp2[2] = 1;
            for (int i = 3; i <= n; i++) {
                dp1[i] = dp1[i-1] + dp1[i-2]*2;
                dp2[i] = dp2[i-1] + dp2[i-2]*2;
                dp1[i]%=10007;
                dp2[i]%=10007;
            }
        }
        long answer = dp1[n] + dp2[n]*2;
        System.out.println(answer%=10007);
    }
}
