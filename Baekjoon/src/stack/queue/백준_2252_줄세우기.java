package stack.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_2252_줄세우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        boolean[] check = new boolean[n+1];
        int[] pos = new int[n+1];
        for(int i=0; i<=n; i++){
            arr.add(new ArrayList<>());
            pos[i] = 0;
            check[i] = false;
        }
        for(int i=0; i<m; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            arr.get(v1).add(v2);
            pos[v2]++;
        }
        for(int i=1; i<=n; i++){
            if(pos[i]==0){
                queue.offer(i);
                check[i] = true;
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            answer.add(temp);
            for (int i = 0; i < arr.get(temp).size(); i++) {
                int t = arr.get(temp).get(i);
                pos[t]--;
                if (pos[t] == 0 && !check[t]) {
                    queue.offer(t);
                }
            }
        }
        for(int i=0; i<answer.size(); i++){
            System.out.print(answer.get(i) + " ");
        }
    }
}