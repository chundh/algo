package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_1916_최소비용구하기 {
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
        StringTokenizer st;
        for(int i=0; i<=n; i++){
            arr.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int wei = Integer.parseInt(st.nextToken());
            arr.get(v1).add(new node(v2, wei));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] len = new int[n+1];
        for(int i=0; i<len.length; i++){
            len[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<node> queue = new PriorityQueue<>();
        arr.get(0).add(new node(start, 0));
        queue.add(arr.get(0).get(0));
        len[start] = 0;
        while(!queue.isEmpty()){
            node temp = queue.poll();
            for(node next : arr.get(temp.num)){
                if(len[next.num] > len[temp.num] + next.weight){
                    len[next.num] = len[temp.num]+next.weight;
                    queue.add(next);
                }
            }
        }
        System.out.println(len[end]);
    }
}
