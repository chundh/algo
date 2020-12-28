package algo;

import java.util.Scanner;

public class 백준_1300_K번째수 {
    static int n, k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        System.out.println(solution(1, k));
    }

    public static int solution(int start, int end){
        if(start>end)
            return start;
        int mid = (start + end)/2;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            cnt += Math.min(mid/i, n);
        }
        if(cnt < k) return solution(mid+1, end);
        else return solution(start, mid-1);
    }
}
