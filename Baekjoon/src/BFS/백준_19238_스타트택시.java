package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_19238_스타트택시 {
    static int n;
    static int m;
    static int[][] map;
    static int[][] length;
    static class info{
        int x;
        int y;

        public info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int liquid = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        info texi = new info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        int[][] start = new int[m][2];
        int[][] end = new int[m][2];
        int[] len = new int[m];
        for(int i=0; i<m; i++){
            String[] d = br.readLine().split(" ");
            start[i][0] = Integer.parseInt(d[0]);
            start[i][1] = Integer.parseInt(d[1]);
            end[i][0] = Integer.parseInt(d[2]);
            end[i][1] = Integer.parseInt(d[3]);
        }

        ArrayList<Integer> complete_arr = new ArrayList<>();
        while(true) {
            if(complete_arr.size() == m){
                break;
            }
            bfs(texi); // 택시 위치부터 모든 목적지까지의 거리를 구함
            for(int i=0; i<m; i++){
                if(complete_arr.contains(i))
                    continue;
                len[i] = length[start[i][0]][start[i][1]]; // i번 목적지의 거리를 갱신
            }
            int min = Integer.MAX_VALUE;
            int min_idx = -1;
            for (int i = 0; i < m; i++) {
                if(complete_arr.contains(i))
                    continue;
                if (min > len[i] && len[i]!=-1) { // 현재 위치로부터 가장 가까운 위치를 탐색
                    min = len[i];
                    min_idx = i;
                }else if(min==len[i] && len[i] != -1){
                    if(start[min_idx][0] > start[i][0]){
                        min_idx = i;
                        min = len[i];
                    }
                    else if(start[min_idx][0] == start[i][0]){
                        if(start[min_idx][1] > start[i][1]){
                            min_idx = i;
                            min = len[i];
                        }
                    }
                }
            } // 갈 수 있는 목적지 중 가장 가까운 거리를 구함
            if(min_idx == -1 || liquid < len[min_idx]){
                System.out.println(-1);
                return;
            }
            liquid -= len[min_idx]; // 현재 위치에서 출발지까지 가는 기름
            int goend = bfs2(new info(start[min_idx][0], start[min_idx][1]), new info(end[min_idx][0], end[min_idx][1])); // 출발지부터 도착지까지 거리
            if(goend==-1 || liquid < goend){
                System.out.println(-1);
                return;
            }
            liquid += goend;
            complete_arr.add(min_idx);
            texi = new info(end[min_idx][0], end[min_idx][1]);
            len = new int[m];
        }
        System.out.println(liquid);
    }

    public static void bfs(info start){
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        Queue<info> queue = new LinkedList<>();
        queue.add(start);
        length = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                length[i][j] = -1;
            }
        }
        length[start.x][start.y] = 0;
        boolean[][] check = new boolean[n+1][n+1];
        check[start.x][start.y] = true;
        while(!queue.isEmpty()){
            info temp = queue.poll();
            for(int i=0; i<4; i++){
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                if(x>n || x<=0 || y>n || y<=0)
                    continue;
                if(!check[x][y] && map[x][y] == 0){
                    length[x][y] = length[temp.x][temp.y] + 1;
                    check[x][y] = true;
                    queue.add(new info(x,y));
                }
            }
        }
    }
    public static int bfs2(info start, info end){
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        Queue<info> queue = new LinkedList<>();
        queue.add(start);
        int[][] len = new int[n+1][n+1];
        len[start.x][start.y] = 0;
        boolean[][] check = new boolean[n+1][n+1];
        check[start.x][start.y] = true;
        while(!queue.isEmpty()){
            info temp = queue.poll();
            if(temp.x == end.x && temp.y == end.y){
                return len[temp.x][temp.y];
            }
            for(int i=0; i<4; i++){
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                if(x>n || x<=0 || y>n || y<=0)
                    continue;
                if(!check[x][y] && map[x][y] == 0){
                    len[x][y] = len[temp.x][temp.y] + 1;
                    check[x][y] = true;
                    queue.add(new info(x,y));
                }
            }
        }
        return -1;
    }
}
/*
6 4 100
0 0 1 0 0 0
0 0 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 1 0
0 0 0 1 0 0
6 5
1 6 2 2
1 6 3 5
1 6 5 4
1 6 1 1
 */