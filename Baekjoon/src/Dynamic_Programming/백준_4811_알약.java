package Dynamic_Programming;

import java.util.Scanner;

public class 백준_4811_알약 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n==0){
                return;
            }
            long[][] dp = new long[n+1][n+1];
            dp[n-1][1] = 1;
            // (n,n) (n,n-1) (n-1 n)/ (n,n-2) (n-1,n-1) (n,n-2)
            int x = n-1;
            int y = 1;
            int max_x = n-1;
            while(true){
                if(dp[x][y] != 0){
                    if(y!=0){
                        dp[x][y-1] += dp[x][y];
                    }
                    if(x>0){
                        dp[x-1][y+1] += dp[x][y];
                    }
                }
                if(x==0 && y==0)
                    break;
                if(x==0){
                    y=0;
                    x= max_x;
                    max_x--;
                }else{
                    x--;
                    y++;
                }
            }
            System.out.println(dp[0][0]);
        }
    }
}
