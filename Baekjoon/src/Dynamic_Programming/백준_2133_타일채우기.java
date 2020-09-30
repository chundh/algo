package Dynamic_Programming;

import java.util.Scanner;

/**
 * 2초과 짝수 인덱스 마다 특수 케이스가 2개씩 나오므로 반복문을 통해 처리해줌
 */

public class 백준_2133_타일채우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 0;
        if(n>=2){
            dp[2] = 3;
            for(int i=3; i<=n; i++){
                if(i%2==0){
                    dp[i] += dp[i-2]*3;
                    for(int j=4; ; j+=2){
                        if(i-j<0)
                            break;
                        dp[i] += dp[i-j]*2;
                    }
                }else{
                    dp[i] = 0;
                }

            }
        }
        System.out.println(dp[n]);
    }
}
