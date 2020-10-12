package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_1197_최소스패닝트리 {
    static class node implements Comparable<node>{
        int num;
        int weight;

        public node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(node o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[] v_arr = new int[v+1];
        ArrayList<ArrayList<node>> arr = new ArrayList<>();
        for(int i=0; i<=v; i++){
            arr.add(new ArrayList<>());
        }
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr.get(v1).add(new node(v2, weight));
            arr.get(v2).add(new node(v1, weight));
        }
        long answer = 0;
        PriorityQueue<node> queue = new PriorityQueue<>();
        queue.add(new node(1,0));
        while(!queue.isEmpty()){
            node temp = queue.poll();
            if(v_arr[temp.num]==1){
                continue;
            }
            answer += temp.weight;
            v_arr[temp.num] = 1;
            for(node next : arr.get(temp.num)){
                if(v_arr[next.num]==0){
                    queue.add(next);
                }
            }
        }
        System.out.println(answer);
    }
}
