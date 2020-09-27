package 다익스트라;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 백준_1753_최단경로 {
    static class node implements Comparable<node> {
        int num;
        int weight;

        public node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }


        @Override
        public int compareTo(node o) {
            return this.weight-o.weight;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(); // 노드의 갯수
        int e = sc.nextInt(); // 엣지의 갯수
        int k = sc.nextInt(); // 시작 정점
        ArrayList<ArrayList<node>> arr= new ArrayList<>();
        for(int i=0; i<=v; i++){
            arr.add(new ArrayList<>());
        }
        for(int i=0; i<e; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();
            arr.get(v1).add(new node(v2, weight));
        }
        PriorityQueue<node> pq = new PriorityQueue<>();
        int[] weight_arr = new int[v+1];
        for(int i=0; i<weight_arr.length; i++){
            weight_arr[i] = Integer.MAX_VALUE;
        }
        pq.add(new node(k, 0));
        weight_arr[k]=0;
        while(!pq.isEmpty()){
            node temp = pq.poll();
            if(temp.weight!=weight_arr[temp.num]){
                continue;
            }else{
                for(node next: arr.get(temp.num)){
                    if(weight_arr[temp.num]+next.weight < weight_arr[next.num]){
                        weight_arr[next.num] = weight_arr[temp.num]+next.weight;
                        pq.add(new node(next.num, weight_arr[next.num]));
                    }
                }
            }
        }
        for (int i = 1; i < weight_arr.length; i++) {
            if(weight_arr[i]==Integer.MAX_VALUE){
                System.out.println("INF");
                continue;
            }
            System.out.println(weight_arr[i]);
        }
    }
}
