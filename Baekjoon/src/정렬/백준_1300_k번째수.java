package 정렬;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 백준_1300_k번째수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n+1][n+1];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                queue.add(i*j);
            }
        }
        for(int i=0; i<k; i++){
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}
