package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_5557_1학년 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];
        String[] d = br.readLine().split(" ");
        for (int i = 0; i < d.length; i++) {
            data[i] = Integer.parseInt(d[i]);
        }
        long[][] dp = new long[n][21];
        dp[0][data[0]] = 1;
        for(int i=1; i<n-1; i++){
            for(int j=0; j<=20; j++){
                if(dp[i-1][j]!=0){
                    long temp = dp[i-1][j];
                    if(j+data[i]<=20){
                        dp[i][j+data[i]] += temp;
                    }
                    if(j-data[i]>=0){
                        dp[i][j-data[i]] += temp;
                    }
                }
            }
        }
        System.out.println(dp[n-2][data[n-1]]);
    }
}
