package stack.queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * Monotone Stack
 * stack을 오름차순, 내림차순으로 정렬상태를 유지하여 임의의 위치 x보다 작거나 큰 왼쪽에 있는 첫 수의 위치를 알 수 있다.
 */

public class 백준_6198_옥상정원 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> arr = new Stack<>();
        int[] dp = new int[n];
        long answer = 0;
        for(int i=0; i<n; i++){
            dp[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            int data = dp[i];
            while(arr.size()!=0 && arr.peek()<=data) arr.pop();
            answer+=arr.size();
            System.out.println(arr.size());
            arr.add(data);
        }
        System.out.println(answer);
    }
}
