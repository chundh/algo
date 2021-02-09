package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while(true){
            if(sum>=s){
                sum -= arr[left++];
                len = Math.min(right-left+1, len);
            } else if(right==n) {
                break;
            } else{
                sum += arr[right++];
            }
        }
        if(len == Integer.MAX_VALUE)
            len = 0;
        System.out.println(len);
    }
}
/*
3 4
1 2 1

3 2
1 3 1
 */