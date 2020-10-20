package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 백준_2568_전깃줄2 {
    static class info implements Comparable<info>{
        int l;
        int r;

        public info(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(info o) {
            return this.l - o.l;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] visit = new boolean[500001];
        info[] arr = new info[n];
        info[] trace = new info[n];
        ArrayList<Integer> lis = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            arr[i] = new info(a,b);
            visit[a] = true;
        }
        Arrays.sort(arr);
        lis.add(arr[0].r);
        trace[0] = new info(0, arr[0].l);
        for(int i=1; i<arr.length; i++){
            if(lis.get(lis.size()-1) < arr[i].r){
                trace[i] = new info(lis.size(), arr[i].l);
                lis.add(arr[i].r);
            }else{
                int idx = lower_bound(lis, arr[i].r);
                lis.set(idx,  arr[i].r);
                trace[i] = new info(idx, arr[i].l);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();	// LIS 수열 값 담기
        int idx = lis.size()-1;
        for(int i=n-1; i>=0; i--){
            if(trace[i].l == idx){
                list.add(trace[i].r);
                idx--;
            }
        }

        // LIS가 아닌 수 출력 방지를 위해 false로 바꾸기
        for(int a : list)
            visit[a] = false;
        System.out.println(n - lis.size());
        // visited가 true인 수는 LIS가 아닌 수 이므로 출력
        for(int i=0; i<=500000; i++){
            if(visit[i])
                System.out.println(i);
        }
    }
    public static int lower_bound(ArrayList<Integer> len, int num){
        int left = 0;
        int right = len.size()-1;
        while(left<right){
            int mid = (left + right)/2;
            if(len.get(mid) >= num){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }
}
