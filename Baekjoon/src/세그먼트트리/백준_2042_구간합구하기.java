package 세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_2042_구간합구하기 {
    static int[] arr;
    static long[] data;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        data = new long[n*4];
        init(1, 1, n);
        for (int i = 0; i < m+k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==1){
                update(1, 1, n, b, c-arr[b]);
                arr[b] = c;
            }else{
                System.out.println(sum(1, 1, n, b, c));
            }
        }

    }
    // 세그먼트 트리 생성
    public static long init(int node, int start, int end){
        if(start==end){
            return data[node] = arr[start];
        }
        int mid = (start + end)/2;
        return data[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
    }

    public static long sum(int node, int start, int end, int left, int right){
        if(start>right || end<left) // 범위에 포함이 안되는 경우
            return 0;
        else if (left<=start && end<=right) { // 범위에 완전히 포함된 경우
            return data[node];
        }
        // 일부분 포함된 경우
        int mid = (start+end)/2;
        return sum(node*2, start, mid, left, right) + sum(node*2+1, mid+1, end, left, right);
    }
    public static void update(int node, int start, int end, int idx, int diff){
        if(start>idx || end<idx) return;
        data[node] += diff;
        if (start==end) return;
        int mid = (start+end)/2;
        update(node*2, start, mid, idx, diff);
        update(node*2+1, mid+1, end, idx, diff);
    }
}
