package Greedy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 백준_2812_크게만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String num = sc.next();
        int range = n-k;
        Deque<Integer> deque = new LinkedList<>();
        String[] arr = num.split("");
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(arr[i]);
            while(k>0 && !deque.isEmpty() && deque.getLast()<temp){
                k--;
                deque.removeLast();
            }
            deque.addLast(temp);
        }
        int cnt = 0;
        while(cnt!=range){
            answer.append(deque.removeFirst());
            cnt++;
        }
        System.out.println(answer);
    }
}
/*
4 2
1924

4 1
1234

4 1
4321

4 1
4444

5 2
13524
 */