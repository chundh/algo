package Dynamic_Programming;

import java.util.Arrays;

public class °Å½º¸§µ· {
    static int mod =  1000000007;
    public static void main(String[] args) {
        int n = 5;
        int[] money = {1,2,5};
        solution(n, money);
    }
    public static int solution(int n, int[] money){
        int[][] dp = new int[money.length+1][n+1];
        Arrays.sort(money);
        for(int i=1; i<money.length+1; i++){
            for(int j=0; j<dp[0].length; j++){
                if(j<money[i-1]){
                    dp[i][j] = dp[i-1][j] % mod;
                }else if(j == money[i-1]){
                    dp[i][j] = (dp[i-1][j] + 1) % mod;
                }else{
                    dp[i][j] = (dp[i-1][j] + dp[i][j-money[i-1]]) % mod;
                }
            }
        }
        for(int i=1; i<money.length+1; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[money.length][n];
    }

}
