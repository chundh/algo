package 이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_1477_휴게소세우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        int[] arr = new int[n+2];
        arr[0] = 0;
        arr[n+1] = l;
        for(int i=1; i<=n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int left = 0;
        int right = l;
        int mid = 0;
        while(left<=right){
            mid = (left+right) / 2;
            int cnt = 0;
            for(int i=1; i<arr.length; i++){
                int num = arr[i] - arr[i-1] -1;
                cnt += num/mid;
            }
            if(cnt>m){
                left = mid+1;
            }else
                right = mid-1;
        }
        System.out.println(left);
    }
}
