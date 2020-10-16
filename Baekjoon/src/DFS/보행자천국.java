package DFS;

public class 보행자천국 {
    static int MOD = 20170805;
    static int answer = 0;
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] cityMap = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
        solution(m, n, cityMap);
    }
    public static int solution(int m, int n, int[][] cityMap){
        int[][][] dp = new int[m+1][n+1][2];
        dp[0][0][0] = 1;
        // 0은 오른쪽 1은 아래쪽
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(cityMap[i][j]==0){
                    dp[i+1][j][0] += (dp[i][j][0] + dp[i][j][1]) % MOD;
                    dp[i][j+1][1] += (dp[i][j][0] + dp[i][j][1]) % MOD;
                }else if(cityMap[i][j] == 2){
                    dp[i+1][j][0] += dp[i][j][0] % MOD;
                    dp[i][j+1][1] += dp[i][j][1] % MOD;
                }
            }
        }
        answer = dp[m-1][n-1][0] + dp[m-1][n-1][1];
        answer %= MOD;
        return answer;
    }
}
