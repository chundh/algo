package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1261_알고스팟 {
    static class node{
        int x;
        int y;
        int cnt;
        public node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[m][n];
        for(int i=0; i<m; i++){
            String[] data = br.readLine().split("");
            for(int j=0; j<data.length; j++){
                map[i][j] = Integer.parseInt(data[j]);
            }
        }
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        Queue<node> queue = new LinkedList<>();
        queue.add(new node(0,0, 0));
        int[][] check = new int[m][n];
        boolean[][] visit = new boolean[m][n];
        while(!queue.isEmpty()){
            node temp = queue.poll();
            if(check[temp.x][temp.y] == 0 && !visit[temp.x][temp.y]){
                check[temp.x][temp.y] = temp.cnt;
            }else{
                if(check[temp.x][temp.y] > temp.cnt){
                    check[temp.x][temp.y] = temp.cnt;
                }else{
                    continue;
                }
            }
            visit[temp.x][temp.y] = true;
            for(int i=0; i<4; i++){
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                if(x>=m || x<0 || y>=n || y<0)
                    continue;
                else{
                    if(map[x][y] == 1)
                        queue.add(new node(x, y, temp.cnt+1));
                    else
                        queue.add(new node(x, y, temp.cnt));
                }
            }
        }
        System.out.println(check[m-1][n-1]);
    }
}
