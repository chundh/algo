package CodingTest.SCPC_5_minor;

import java.util.Scanner;

public class Similiar {
    static int[] arr1;
    static int[] arr2;
    static int[][] reverse_dp;
    static int n;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
            answer=0;
            n = sc.nextInt();
            arr1 = new int[n];
            arr2 = new int[n];
            int[] dp = new int[n];
            reverse_dp = new int[n][n];
            for(int i=0; i<n; i++){
                arr1[i] = sc.nextInt();
            }
            for(int i=0; i<n; i++){
                arr2[i] = sc.nextInt();
                if(i==0){
                    if(arr1[0] == arr2[0])
                        dp[0] = 1;
                    else
                        dp[0] = 0;
                }else{
                    if(arr1[i] == arr2[i])
                        dp[i] = dp[i-1]+1;
                    else
                        dp[i] = dp[i-1];
                }
            }
            for(int i=0; i<n; i++)
                for (int j=0; j<n; j++)
                    reverse_dp[i][j] = -1;

            for(int i=0; i<n-1; i++){
                for(int j=i+1; j<n; j++){
                    int ans = DPReverse(i, j);
                    if(i!=0){
                        ans += dp[i-1];
                    }
                    ans+=dp[n-1]-dp[j];
                    if(answer<ans) {
                        answer = ans;
                    }
                }
            }
            System.out.println("Case #"+(test_case+1));
            System.out.println(answer);
        }
    }


    public static int DPReverse(int start, int end){
        if(reverse_dp[start][end]>=0)
            return reverse_dp[start][end];
        if(start==end){
            if(arr1[start] == arr2[end])
                return 1;
            return 0;
        }
        else if(start==end-1){
            int num = 0;
            if(arr1[start] == arr2[end])
                num++;
            if(arr1[end] == arr2[start])
                num++;
            return num;
        }
        int answer = 0;
        if(arr1[start] == arr2[end])
            answer++;
        if(arr1[end] == arr2[start])
            answer++;
        answer += DPReverse(start+1, end-1);
        if(reverse_dp[start][end]<answer)
            reverse_dp[start][end] = answer;
        return answer;
    }
}
