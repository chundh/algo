package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_1697_숨바꼭질 {
    static int[] check = new int[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> arr = new LinkedList<>();
        arr.offer(n);
        check[n] = 1;
        int time = 0;
        int cnt=0;
        int size=arr.size();
        if(n==k){
            System.out.println(0);
            return;
        }
        while(true){
            if(check[k] != 0){
                System.out.println(time+1);
                break;
            }
            if(size==cnt){
                time++;
                size = arr.size();
                cnt = 0;
            }
            int data = arr.poll();
            int data1 = data-1;
            int data2 = data+1;
            int data3 = data*2;
            if(data1<100001 && data1>=0) {
                if (check[data1] == 0) {
                    arr.offer(data1);
                    check[data1] = 1;
                }
            }
            if(data2<100001 && data2 >= 0) {
                if (check[data2] == 0) {
                    arr.offer(data2);
                    check[data2] = 1;
                }
            }
            if(data3<100001 && data3 >= 0) {
                if (check[data3] == 0) {
                    arr.offer(data3);
                    check[data3] = 1;
                }
            }
            cnt++;
        }
    }
}
