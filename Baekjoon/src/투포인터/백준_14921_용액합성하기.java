package 투포인터;

import java.util.Scanner;

public class 백준_14921_용액합성하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int start = 0;
        int end = n-1;
        int min = Integer.MAX_VALUE;
        while(start<end){
            int sum = arr[start] + arr[end];
            if(Math.abs(sum)<Math.abs(min)){
                min = sum;
            }
            if(Math.abs(arr[start]) > Math.abs(arr[end])){
                start++;
            }else{
                end--;
            }
        }
        System.out.println(min);
    }
}
