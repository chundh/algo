package 백트래킹;

import java.util.Scanner;

public class 백준_1182_부분수열의합 {
    static int answer;
    static int[] arr;
    static int s;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        recur(0,0);
        if(s==0)
            answer--;
        System.out.println(answer);

    }

    public static void recur(int cur, int tot){
        if(cur==n) {
            if (tot == s) answer++;
            return;
        }
        recur(cur+1, tot);
        recur(cur+1, tot+arr[cur]);
    }
}
