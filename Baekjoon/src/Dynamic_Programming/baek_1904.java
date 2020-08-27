package Dynamic_Programming;

import java.util.Scanner;

/**
 * n=1 -> 1 : 1
 * n=2 -> 00 11 : 2
 * n=3 -> 001 100 111 : 3
 * n=4 -> 0000 0011 1100 1001 1111 : 5
 * n=5 -> 00001 10000 00100 11100 00111 10011 11001 11111 : 8
 */

public class baek_1904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        if(n>=3) {
            for (int i = 3; i <= n; i++) {
                arr[i] = (arr[i-1] + arr[i-2])%15746;
            }
        }
        System.out.println(arr[n]);
    }
}
