package 알고리즘구현.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 다익스트라 {
    static class node implements Comparable<node>{
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
        // u->v 가중치 w, 1번노드에서 시작
        // 정점의 수=5
        int num = 5;
        String[] data = {"5 1 1",
                "1 2 2",
                "1 3 3",
                "2 3 4",
                "2 4 5",
                "3 4 6"};
        // list를 통해 간선을 표시한다.
        ArrayList<ArrayList<node>> arr= new ArrayList<>();
        for(int i=0; i<=num; i++){
            arr.add(new ArrayList<>());
        }
        // list.get(u)에 v와 w를 추가하며 연결관계를 만든다.
        for(int i=0; i<data.length; i++){
            String[] temp = data[i].split(" ");
            int u = Integer.parseInt(temp[0]);
            int v = Integer.parseInt(temp[1]);
            int w = Integer.parseInt(temp[2]);
            arr.get(u).add(new node(v,w));
        }
        // 우선순위 큐를 사용하며 1번부터 탐색을 시작한다.
        // 우선순위 큐를 통해 현재 갈 수 있는 노드 중 가중치가 가장 작은 노드를 먼저 탐색한다.
        PriorityQueue<node> queue = new PriorityQueue<>();
        queue.add(new node(1,0));
        // 전체 거리를 큰 수로 초기화 해준다.
        int[] len = new int[data.length];
        for (int i = 0; i < len.length; i++) {
            len[i] = Integer.MAX_VALUE;
        }
        len[1] = 0;
        while(!queue.isEmpty()){
            node temp = queue.poll();
            // len에 있는 최단거리와 현재의 가중치가 다른 경우
            // 다른 경로를 통해 최단거리가 업데이트 되었으므로 쓸모 없는 경로다.
            if(temp.weight != len[temp.num])
                continue;
            for(node next : arr.get(temp.num)){
                // 현재까지 temp에 도달하는 거리보다 갱신된 거리가 더 짧은 경우
                if(len[temp.num] + next.weight < len[next.num]){
                    // 최단 경로를 갱신하고 next노드를 탐색 대상에 추가한다.
                    len[next.num] = len[temp.num] + next.weight;
                    queue.add(new node(next.num , len[next.num]));
                }
            }
        }
        System.out.println(Arrays.toString(len));
    }
}
