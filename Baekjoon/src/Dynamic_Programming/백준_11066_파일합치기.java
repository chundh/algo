package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
다시풀기. 전혀 모르겠다.
 */

public class 백준_11066_파일합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t<tc; t++){
            int n = Integer.parseInt(br.readLine());
            int[] sum = new int[n+1];
            int[] v = new int[n];
            String[] data = br.readLine().split(" ");
            int[][] dp = new int[n][n];
            for(int i=0; i<n; i++){
                v[i] = Integer.parseInt(data[i]);
                if(i==0)
                    sum[i] = v[i];
                else
                    sum[i] = sum[i-1] + v[i];
            }
            for(int i=0; i<n-1; i++){
                dp[i][i+1] = v[i] + v[i+1];
            }
            for (int j = 2; j < n; j++) {
                for(int i=0; i+j<n; i++){
                    for(int k=i; k<i+j; k++){
                        if(dp[i][i+j]==0)
                            dp[i][i+j] = dp[i][k] + dp[k+1][i+j] + sumDistance(i, i+j, sum);
                        else
                            dp[i][i+j] = Math.min(dp[i][i+j], dp[i][k] + dp[k+1][i+j] + sumDistance(i, i+j, sum));
                    }
                }
            }

            for (int i = 0; i <n; i++) {
                for(int j=0; j<n; j++){
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(dp[0][n-1]);
        }
    }
    static Integer sumDistance(int i, int j, int[] sum) {
        if (i == 0)
            return sum[j]; // 시작 부분이 처음일 때는 j까지만
        else
            return sum[j] - sum[i-1]; // i~j구간의 합만큼의 합산
    }
}
