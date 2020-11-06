package 세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class 백준_1725_히스토그램 {
    static int[] arr;
    static int[] data;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        data = new int[n*4];
        init(1,1,n);
        System.out.println(getWidth(1,1,n, 1, n));
    }
    public static int init(int node, int start, int end){
        if(start==end)
            return data[node] = start;
        int mid = (start+end)/2;
        int v1 = init(node*2, start, mid);
        int v2 = init(node*2+1, mid+1, end);
        if(arr[v1]>arr[v2]){
            data[node] = v2;
        }else
            data[node] = v1;
        return data[node];
    }

    // left~right 구간에서 가장 높이가 작은 node의 idx
    public static int findidx(int node, int start, int end, int left, int right){
        if(left>end || right<start)
            return Integer.MAX_VALUE;
        if(left<=start && end<=right){
            return (int) data[node];
        }else{
            int mid=(start+end)/2;
            int v1 = findidx(node*2, start, mid, left, right);
            int v2 = findidx(node*2+1, mid+1, end, left, right);
            if(v1!=Integer.MAX_VALUE && v2!=Integer.MAX_VALUE) {
                if (arr[v1] > arr[v2]) {
                    data[node] = v2;
                } else
                    data[node] = v1;
            }else{
                data[node] = Math.min(v1, v2);
            }
            return data[node];
        }
    }
    public static long getWidth(int node, int start, int end, int left, int right){
        int minidx = findidx(node, start, end, left, right);
        int height = arr[minidx];
        long wid = height*(right-left+1);
        if(left<minidx){
            long temp = getWidth(1, start, end, left, minidx-1);
            wid = Math.max(temp, wid);
        }
        if(right>minidx){
            long temp = getWidth(1, start, end, minidx+1, right);
            wid = Math.max(temp, wid);
        }
        return wid;
    }
}
