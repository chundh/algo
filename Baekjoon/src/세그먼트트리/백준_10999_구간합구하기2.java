package 세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * lazy를 이용해야함
 * https://bowbowbow.tistory.com/4
 */

public class 백준_10999_구간합구하기2 {
    static int[] arr;
    static long[] data;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        data = new long[N*4];
        init(1,1,N);
        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int opt = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            if (opt == 1) {
                int dif = Integer.parseInt(st.nextToken());
                update(1, 1, N, left, right, dif);
            }else{
                System.out.println(sum(1, 1, N, left, right));
            }
        }
    }
    public static long init(int node, int start, int end){
        if(start==end){
            return data[node] = arr[start];
        }else{
            int mid = (start+end)/2;
            return data[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
        }
    }
    public static long sum(int node, int start, int end, int left, int right){
        if(left>end || right<start)
            return 0;
        if(left<=start && end<=right){
            return data[node];
        }else{
            int mid = (start+end)/2;
            return sum(node*2, start, mid, left, right) + sum(node*2+1, mid+1, end, left, right);
        }
    }
    public static void update(int node, int start, int end, int left, int right, int dif){
        if(left>end || right<start)
            return;
        if(left<=start && end<=right){
            data[node] += dif*(end-start+1);
            if(start!=end) {
                int mid = (start+end)/2;
                update(node * 2, start, mid, left, right, dif);
                update(node * 2 + 1, mid + 1, end, left, right, dif);
            }
            return;
        }
        int cnt = getCount(start, end, left, right);
        data[node] += dif*cnt;
        int mid = (start+end)/2;
        update(node*2, start, mid, left, right, dif);
        update(node*2+1, mid+1, end, left, right, dif);
    }
    public static int getCount(int start, int end, int left, int right){
        int cnt = 0;
        for (int i = start; i <= end; i++) {
            if(i<=right && i>=left){
                cnt++;
            }
        }
        return cnt;
    }
}
