package stack.queue;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 백준_1766_문제집 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int[] pos = new int[n+1];
        for(int i=0; i<=n; i++){
            arr.add(new ArrayList<>());
            pos[i] = 0;
        }
        for(int i=0; i<m; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            arr.get(v1).add(v2);
            pos[v2]++;
        }
        for(int i=1; i<=n; i++){
            if(pos[i]==0){
                queue.add(i);
                pos[i] = -1;
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()){
            int temp = queue.poll();
            answer.add(temp);
            for(int nextv : arr.get(temp)){
                pos[nextv]--;
                if(pos[nextv]==0){
                    queue.add(nextv);
                    pos[nextv] = -1;
                }
            }
        }
        for(int i=0; i<answer.size(); i++){
            System.out.print(answer.get(i) + " ");
        }
    }
}
