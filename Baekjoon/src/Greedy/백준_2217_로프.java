package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ����_2217_���� {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int answer = 0;
        int cnt = 0;
        for(int i=n-1; i>=0; i--){
            cnt++;
            answer = Math.max(answer, arr[i]*cnt);
        }
        System.out.println(answer);
    }
}
