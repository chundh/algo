package algo;

import java.util.Scanner;

public class 백준_11057_오르막수 {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[1001][10];
        for (int i = 0; i < 10; i++) {
            arr[0][i] = 1;
        }
        for (int i = 1; i <= 1000; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    arr[i][j] += arr[i-1][k];
                    arr[i][j] %= 10007;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += arr[n-1][i];
            answer %= 10007;
        }
        System.out.println(answer);
    }

}
/*
1 : 10
2 : 55
3 : 220
4 : 715
5 : 2002
6 : 5005
 */