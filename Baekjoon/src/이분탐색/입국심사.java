package 이분탐색;

import java.util.ArrayList;

public class 입국심사 {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        soluiton(n, times);
    }
    public static long soluiton(int n, int[] times){
        int max = 0;
        for(int i=0; i<times.length; i++){
            max = Math.max(max, times[i]);
        }
        long answer = 0;
        answer = binarySearch(n, max, times);
        return answer;
    }
    public static long binarySearch(int n, long m, int[] times){
        long left = 1;
        long right = m*n;
        long ans = Long.MAX_VALUE;
        while(left<=right){
            long mid = (left+right) / 2;
            if(check_range(mid, times, n)){
                ans = Math.min(ans, mid);
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
    public static boolean check_range(long mid, int[]times, int n){
        long sum = 0;
        for(int i=0; i<times.length; i++){
            sum += mid/times[i];
        }
        if(sum>=n)
            return true;
        else
            return false;
    }
}
