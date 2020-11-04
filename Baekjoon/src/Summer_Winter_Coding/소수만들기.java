package Summer_Winter_Coding;

import java.util.ArrayList;
import java.util.Arrays;

public class 소수만들기 {
    static boolean[] arr = new boolean[3001];
    static int answer;
    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        solution(nums);
    }
    public static int solution(int[] nums){
        makeArr();
        recur(nums, 0, 0, 0);
        System.out.println(answer);

        return 0;
    }
    public static void makeArr(){
        int n = arr.length; // 소수이면 false로 저장
        arr[0] = true;
        arr[1] = true;
        for(int i=2; i*i<=arr.length; i++){
            if(arr[i]) {
                continue;
            }
            for(int j = i*i; j<=n; j+=i){
                arr[j] = true;
            }
        }
    }
    public static void recur(int[] nums, int idx, int cnt, int sum){
        if(cnt==3){
            if(!arr[sum]) {
                answer++;
            }
            return;
        }
        if(idx>=nums.length)
            return;
        for (int i=idx; i<nums.length; i++){
            recur(nums, i+1, cnt+1, sum+nums[i]);
        }
    }
}
