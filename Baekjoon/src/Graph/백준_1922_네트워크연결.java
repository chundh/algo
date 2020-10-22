package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_1922_네트워크연결 {
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
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<node>> arr = new ArrayList<>();
        for(int i=0; i<=n; i++){
            arr.add(new ArrayList<>());
        }
        int min = Integer.MAX_VALUE;
        int min_idx = 0;
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.get(v1).add(new node(v2, w));
            arr.get(v2).add(new node(v1, w));
            if(min>w){
                min = w;
                min_idx = v1;
            }
        }
        int[] dist = new int[n+1];
        int[] from = new int[n+1];
        for(int i=0; i<=n; i++){
            dist[i] = Integer.MAX_VALUE;
            from[i] = i;
        }
        from[min_idx] = min_idx;
        dist[min_idx] = 0;
        PriorityQueue<node> queue = new PriorityQueue<>();
        queue.add(new node(min_idx, 0));
        int answer = 0;
        while(!queue.isEmpty()){
            node temp = queue.poll();
            if(temp.weight != dist[temp.num])
                continue;
            dist[temp.num] = 0;
            answer += temp.weight;
            for(node next : arr.get(temp.num)){
                if(dist[next.num] > next.weight){
                    dist[next.num] = next.weight;
                    from[next.num] = temp.num;
                    queue.add(next);
                }
            }
        }
        System.out.println(answer);
    }
}
