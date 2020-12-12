package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_16236_아기상어 {
    static class point{
        int x;
        int y;
        int cnt;
        int size;
        public point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        point shark = null;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    shark = new point(i, j, 0);
                    shark.size = 2;
                }
            }
        }
        int answer = 0;
        while(true){
            point min = new point(-1, -1, 0);
            int minlen = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i==shark.x && j == shark.y)
                        continue;
                    if(map[i][j] != 0 && map[i][j] < shark.size){
                        int templen = find_len(map, shark.x, shark.y, i, j, shark.size);
                        if (templen == -1)
                            continue;
                        if(minlen > templen){
                            minlen = templen;
                            min = new point(i, j, 0);
                        }else if(minlen == templen){
                            if(min.x > i){
                                minlen = templen;
                                min = new point(i, j, 0);
                            }else if(min.x == i){
                                if(min.y > j){
                                    minlen = templen;
                                    min = new point(i, j, 0);
                                }
                            }
                        }
                    }
                }
            }
            // 갈 곳이 없는 경우
            if(minlen == Integer.MAX_VALUE){
                break;
            }else{
                answer += minlen;
                map[shark.x][shark.y] = 0;
                map[min.x][min.y] = 9;
                shark.cnt++;
                if(shark.cnt==shark.size){
                    shark.size++;
                    shark.cnt = 0;
                }
                shark.x = min.x;
                shark.y = min.y;
            }
        }
        System.out.println(answer);
    }
    public static int find_len(int[][] map, int startx, int starty, int endx, int endy, int shark){
        Queue<point> queue = new LinkedList<>();
        queue.add(new point(startx, starty, 0));
        boolean[][] check = new boolean[map.length][map.length];
        check[startx][starty] = true;
        while(!queue.isEmpty()){
            point temp = queue.poll();
            if(temp.x == endx && temp.y == endy)
                return temp.cnt;
            for (int i = 0; i < 4; i++) {
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                if(x<0 || y<0 || x>=map.length || y>=map.length)
                    continue;
                if(map[x][y] > shark)
                    continue;
                if(check[x][y])
                    continue;;
                queue.add(new point(x, y, temp.cnt+1));
                check[x][y] = true;
            }
        }
        return -1;
    }
}
