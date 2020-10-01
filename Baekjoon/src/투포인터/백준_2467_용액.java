package 투포인터;

import java.util.Scanner;

public class 백준_2467_용액 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int start = 0;
        int end = n-1;
        long min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while(start<end){
            long sum = arr[start] + arr[end];
            if(Math.abs(sum)<Math.abs(min)){
                min = sum;
                answer[0] = (int) arr[start];
                answer[1] = (int) arr[end];
            }
            if(Math.abs(arr[start]) > Math.abs(arr[end])){
                start++;
            }else{
                end--;
            }
        }
        System.out.println(answer[0] + " , " + answer[1]);
    }
}
