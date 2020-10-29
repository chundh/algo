package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
�ٽ�Ǯ��. ���� �𸣰ڴ�.
 */

public class ����_11066_������ġ�� {
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
            return sum[j]; // ���� �κ��� ó���� ���� j������
        else
            return sum[j] - sum[i-1]; // i~j������ �ո�ŭ�� �ջ�
    }
}
