package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] weight = new int[n+1];
        int[] v = new int[n+1];
        for(int i=1; i<=n; i++){
            String[] data = br.readLine().split(" ");
            int temp_weight = Integer.parseInt(data[0]);
            int temp_value = Integer.parseInt(data[1]);
            weight[i] = temp_weight;
            v[i] = temp_value;
        }
        int[][] dp = new int[n+1][k+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=k; j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if(j>=weight[i]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + v[i]);
                }
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=k; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[n][k]);
    }
}