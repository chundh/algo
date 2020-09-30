package Dynamic_Programming;

import java.util.Scanner;

/**
 * 2�ʰ� ¦�� �ε��� ���� Ư�� ���̽��� 2���� �����Ƿ� �ݺ����� ���� ó������
 */

public class ����_2133_Ÿ��ä��� {
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
