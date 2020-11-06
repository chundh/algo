package 세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2357_최솟값과최댓값 {
    static int[] arr;
    static int[][] data;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        data = new int[N*4][2];
        init(1, 1, N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int[] data = find(1, 1, N, v1, v2);
            System.out.println(data[0] + " " + data[1]);
        }
    }
    public static int[] init(int node, int start, int end){
        if(start==end){
            data[node][0] = arr[start];
            data[node][1] = arr[start];
            return data[node];
        }
        int mid = (start+end)/2;
        int[] v1 = init(node*2, start,mid);
        int[] v2 = init(node*2+1, mid+1, end);
        data[node][0] = Math.min(v1[0], v2[0]);
        data[node][1] = Math.max(v1[1], v2[1]);
        return data[node];
    }
    public static int[] find(int node, int start, int end, int left, int right){
        if(left>end || right<start)
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        if(left<=start && end<=right){
            return data[node];
        }else{
            int mid = (start+end)/2;
            int[] v1 = find(node*2, start,mid, left, right);
            int[] v2 = find(node*2+1, mid+1, end, left, right);
            int[] ans = new int[2];
            ans[0] = Math.min(v1[0], v2[0]);
            ans[1] = Math.max(v1[1], v2[1]);
            return ans;
        }
    }
}
