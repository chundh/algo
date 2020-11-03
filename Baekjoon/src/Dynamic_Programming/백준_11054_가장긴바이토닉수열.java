package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_11054_가장긴바이토닉수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp_asc = new int[n];
        int[] dp_desc = new int[n];
        for(int i=0; i<n; i++){
            dp_asc[i] = 1;
            dp_desc[i] = 1;
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j] && dp_asc[i]<=dp_asc[j])
                    dp_asc[i] = dp_asc[j]+1;
            }
        }
        for(int i=n-2; i>=0; i--){
            for(int j=n-1; j>i; j--){
                if(arr[i]>arr[j] && dp_desc[i]<=dp_desc[j])
                    dp_desc[i] = dp_desc[j]+1;
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int sum = dp_asc[i] + dp_desc[i] -1;
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}
