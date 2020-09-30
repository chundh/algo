package Dynamic_Programming;

import java.util.Scanner;

public class 백준_9461_파도반수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long[] arr = new long[101];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 2;
        arr[4] = 2;
        for(int i=5; i<arr.length; i++){
            arr[i] = arr[i-1] + arr[i-5];
        }
        for(int test=0; test<t; test++){
            int n = sc.nextInt();

            System.out.println(arr[n-1]);
        }
    }
}
