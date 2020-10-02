package DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// 다시풀어보기

public class 백준_13913_숨바꼭질4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> arr = new LinkedList<>();
        int[] check = new int[100001];
        int[] path = new int[100001];
        arr.offer(n);
        check[n] = 1;
        int time = 0;
        int cnt=0;
        int size=arr.size();
        if(n==k){
            System.out.println(0);
            return;
        }
        while(!arr.isEmpty()){
            int data = arr.poll();
            if(data == k){
                int idx = k;
                Stack<Integer> stack = new Stack<>();
                while(true){
                    if(idx==n) {
                        stack.push(idx);
                        break;
                    }
                    stack.push(idx);
                    idx = path[idx];
                }
                int s = stack.size();
                System.out.println(s-1);
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<s; i++){
                    sb.append(stack.pop() + " ");
                }
                System.out.println(sb.toString());
            }
            if(size==cnt){
                time++;
                size = arr.size();
                cnt = 0;
            }
            int data1 = data-1;
            int data2 = data+1;
            int data3 = data*2;
            if(data1<100001 && data1>=0) {
                if (check[data1] == 0) {
                    arr.offer(data1);
                    check[data1] = 1;
                    path[data1] = data;
                }
            }
            if(data2<100001 && data2 >= 0) {
                if (check[data2] == 0) {
                    arr.offer(data2);
                    check[data2] = 1;
                    path[data2] = data;
                }
            }
            if(data3<100001 && data3 >= 0) {
                if (check[data3] == 0) {
                    arr.offer(data3);
                    check[data3] = 1;
                    path[data3] = data;
                }
            }
            cnt++;
        }
    }
}
