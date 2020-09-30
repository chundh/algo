package Dynamic_Programming;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 백준_2294_동전2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] dp = new int[100001];
        int[] arr = new int[n];
        for(int i=0; i<dp.length; i++){
            dp[i] = 100001;
        }
        for(int i=0; i<n; i++){
            int idx = sc.nextInt();
            dp[idx] = 1;
            arr[i] = idx;
        }
        dp[0] = 0;
        for(int i=1; i<=k; i++){
            int temp = i;
            for(int j=0; j<n; j++){
                if(temp-arr[j]<0)
                    continue;
                if(dp[temp-arr[j]]==0 || temp-dp[temp-arr[j]]<0){
                    continue;
                }else{
                    dp[i] = Math.min(dp[i], dp[temp-arr[j]]+1);
                }
            }
        }
        if(dp[k] == 100001)
            System.out.println(-1);
        else
            System.out.println(dp[k]);

    }
}
