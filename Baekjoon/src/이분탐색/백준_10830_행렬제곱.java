package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_10830_행렬제곱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] data = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(data[j]);
            }
        }
        int[][] answer = multi(arr, b);
        for (int i = 0; i < n; i++) {
            for(int j=0; j<n; j++){
                System.out.print(answer[i][j]%1000 + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multi(int[][] arr, long b){
        if(b==1)
            return arr;
        int[][] temp = multi(arr, b/2);
        int[][] ans = new int[arr.length][arr.length];
        for(int i = 0 ; i < arr.length ; ++i){
            for(int j = 0 ; j < arr.length ; ++j){
                for(int k = 0 ; k < arr.length ; ++k) {
                    ans[i][j] += (temp[i][k] * temp[k][j])%1000;
                }
            }
        }
        if(b%2==1){
            int[][] re_ans = new int[arr.length][arr.length];
            for(int i = 0 ; i < arr.length ; ++i){
                for(int j = 0 ; j < arr.length ; ++j){
                    for(int k = 0 ; k < arr.length ; ++k) {
                        re_ans[i][j] += (ans[i][k] * arr[k][j])%1000;
                    }
                }
            }
            return re_ans;
        }else{
            return ans;
        }
    }
}