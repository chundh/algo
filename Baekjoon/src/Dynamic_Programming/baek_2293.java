package Dynamic_Programming;

import java.util.Scanner;

public class baek_2293 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[k+1];
        dp[0] =1;
        for(int i=0; i<n; i++){
            for(int j=arr[i]; j<=k; j++){
                dp[j] += dp[j-arr[i]];
            }
        }
        System.out.println(dp[k]);
    }
}
