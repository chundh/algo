package BFS;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프로그래머스_지형이동 {
    static int[] parent;
    static class point{
        int x;
        int y;
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class data implements Comparable<data>{
        int start;
        int end;
        int weight;
        public data(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(data o) {
            return this.weight - o.weight;
        }
    }
    public static int find(int v1){
        if(parent[v1] == v1)
            return v1;
        return parent[v1] = find(parent[v1]);
    }
    public static void union(int v1, int v2){
        int p_v1 = find(v1);
        int p_v2 = find(v2);
        if(p_v1==p_v2)
            return;
        if(p_v1>p_v2)
            parent[p_v1] = p_v2;
        else
            parent[p_v2] = p_v1;
    }
    public static void main(String[] args) {
        int[][] land = {{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}};
        int height = 7;
        solution(land, height);
    }
    public static int solution(int[][] land, int height){
        int[][] map = new int[land.length][land[0].length];
        int cnt = 1;
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land.length; j++) {
                if (map[i][j] == 0) {
                    bfs(land, map, i, j, cnt, height);
                    cnt++;
                }
            }
        }
        PriorityQueue<data> priorityQueue = new PriorityQueue<>();
        findWeight(land, map, 0,0, priorityQueue);
        int answer = 0;
        parent = new int[cnt];
        for(int i=0; i<cnt; i++){
            parent[i] = i;
        }
        while(!priorityQueue.isEmpty()){
            data temp = priorityQueue.poll();
            int v1 = temp.start;
            int v2 = temp.end;
            if(find(v1) == find(v2))
                continue;
            else{
                answer += temp.weight;
                union(v1, v2);
            }
        }
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(answer);
        return answer;
    }
    public static void bfs(int[][] land, int[][] map, int x, int y, int data, int height){
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        Queue<point> queue = new LinkedList<>();
        map[x][y] = data;
        queue.add(new point(x, y));
        while(!queue.isEmpty()){
            point temp = queue.poll();
            for(int i=0; i<4; i++){
                int new_x = temp.x + dx[i];
                int new_y = temp.y + dy[i];
                if(new_x<0 || new_x>=map.length || new_y<0 || new_y>=map[0].length)
                    continue;
                if(map[new_x][new_y]==0 && Math.abs(land[new_x][new_y] - land[temp.x][temp.y]) <= height){
                    queue.add(new point(new_x, new_y));
                    map[new_x][new_y] = data;
                }
            }
        }
    }
    public static void findWeight(int[][] land, int[][] map, int x, int y, PriorityQueue<data> pq){
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        Queue<point> queue = new LinkedList<>();
        queue.add(new point(x, y));
        boolean[][] visit = new boolean[land.length][land[0].length];
        visit[x][y] = true;
        while(!queue.isEmpty()){
            point temp = queue.poll();
            for(int i=0; i<4; i++){
                int new_x = temp.x + dx[i];
                int new_y = temp.y + dy[i];
                if(new_x<0 || new_x>=map.length || new_y<0 || new_y>=map[0].length)
                    continue;
                if(!visit[new_x][new_y]){
                    queue.add(new point(new_x, new_y));
                    visit[new_x][new_y] = true;
                }
                if(map[new_x][new_y] != map[temp.x][temp.y])
                    pq.add(new data(map[new_x][new_y], map[temp.x][temp.y], Math.abs(land[new_x][new_y] - land[temp.x][temp.y])));
            }
        }
    }
}
