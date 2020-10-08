package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_1963_소수경로 {
    static class info{
        int num;
        int cnt;

        public info(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] check = new boolean[10000];
        check[1] = false; // 소수면 false
        for (int i = 2; i * i < 10000; i++) {
            if (check[i]) continue;
            for (int j = i * i; j < 10000; j += i)
                check[j] = true;
        }
        int tc = sc.nextInt();
        for(int test_case = 0; test_case<tc; test_case++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            boolean[] visit = new boolean[10000];
            Queue<info> queue = new LinkedList<>();
            queue.add(new info(start, 0));
            visit[start] = true;
            while(true){
                info temp = queue.poll();
                if(temp.num>=10000){
                    System.out.println(-1);
                    break;
                }
                if(temp.num==end){
                    System.out.println(temp.cnt);
                    break;
                }
                for(int i=1000; i<10000; i++){
                    if(!check[i] && find(temp.num, i) && !visit[i]){
                        queue.add(new info(i, temp.cnt+1));
                        visit[i] = true;
                    }
                }
            }
        }
    }
    static boolean find (int num1, int num2){
        String n1 = String.valueOf(num1);
        String n2 = String.valueOf(num2);
        int cnt=0;
        for(int i=0; i<4; i++){
            if(n1.charAt(i) != n2.charAt(i))
                cnt++;
        }
        if(cnt==1)
            return true;
        else
            return false;
    }
}
