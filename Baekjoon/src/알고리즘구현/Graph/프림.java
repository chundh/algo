package 알고리즘구현.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 최소 신장트리를 구하는 알고리즘이다.
 * 시작 노드로 부터 사이클 없는 그래프를 완성시킨다.
 * 우선순위 큐를 사용해 현재 갈 수 있는 간선 중 가중치가 가장 낮은 것을 택한다.
 * 한번 방문한 노드의 거리는 0으로 바꿔주고 중복과 싸이클이 생기는 것을 막는다.
 * 모든 간선을 탐색하면서 최소 신장 트리를 완성한다.
 */

public class 프림 {
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
    public static void main(String[] args) {
        String[] data = {"5 1 1",
                "1 2 2",
                "1 3 3",
                "2 3 4",
                "2 4 5",
                "3 4 6"};
        int v = 5;
        int e = data.length;
        ArrayList<ArrayList<node>> arr = new ArrayList<>();
        for(int i=0; i<=v; i++){
            arr.add(new ArrayList<>());
        }
        for(int i=0; i<e; i++){
            String[] temp = data[i].split(" ");
            int v1 = Integer.parseInt(temp[0]);
            int v2 = Integer.parseInt(temp[1]);
            int w = Integer.parseInt(temp[2]);
            arr.get(v1).add(new node(v2, w));
            arr.get(v2).add(new node(v1, w));
        }
        // i번째 노드가 어디와 연결되는 것인지 정보 저장
        int[] from = new int[v+1];
        // 탐색할 때 가장 가중치가 작은 간선을 찾을 때 활용
        int[] dist = new int[v+1];
        for(int i=1; i<=v; i++){
            dist[i] = Integer.MAX_VALUE;
            from[i] = 0;
        }
        from[1] = 1;
        dist[1] = 0;
        PriorityQueue<node> queue = new PriorityQueue<>();
        queue.add(new node(1,0));
        while(!queue.isEmpty()){
            node temp = queue.poll();
            // temp의 weight가 dist의 값과 다르다면 최단거리 갱신 전의 데이터이므로 continue한다.
            if(temp.weight != dist[temp.num])
                continue;
            dist[temp.num] = 0;
            for(node next : arr.get(temp.num)){
                if(dist[next.num] > next.weight){
                    dist[next.num] = next.weight;
                    from[next.num] = temp.num;
                    queue.add(new node(next.num, dist[next.num]));
                }
            }
        }
        System.out.println(Arrays.toString(from));
        System.out.println(Arrays.toString(dist));
    }
}
