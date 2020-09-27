package 투포인터;

import java.util.Scanner;

public class 백준_2003_수들의합2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int start = 0;
        int end = 0;
        int sum= 0;
        int answer = 0;
        while (true) {
            if (sum >= m)
                sum -= arr[start++];
            else if (end == n)
                break;
            else
                sum += arr[end++];
            if (sum == m)
                ++answer;
        }
        System.out.println(answer);
    }
}
