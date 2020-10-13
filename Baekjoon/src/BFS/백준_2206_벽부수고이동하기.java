package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2206_벽부수고이동하기 {
    static class info{
        int x;
        int y;
        int time;
        int cnt;

        public info(int x, int y, int time, int cnt) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            String[] data = br.readLine().split("");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(data[j]);
            }
        }
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        boolean[][][] len = new boolean[n][m][2];
        Queue<info> queue = new LinkedList<>();
        queue.add(new info(0,0, 1, 0));
        len[0][0][0] = true;
        len[0][0][1] = true;

        while(!queue.isEmpty()){
            info temp = queue.poll();
            if(temp.x==n-1 && temp.y == m-1){
                System.out.println(temp.time);
                return;
            }

            for(int i=0; i<4; i++){
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                if(x>=n || x<0 || y>=m || y<0)
                    continue;
                if(map[x][y] == 0){
                    if(len[x][y][temp.cnt])
                        continue;
                    queue.add(new info(x,y,temp.time+1, temp.cnt));
                    len[x][y][temp.cnt] = true;
                }else{
                    if(temp.cnt==0){
                        if(len[x][y][temp.cnt+1])
                            continue;
                        queue.add(new info(x,y,temp.time+1, temp.cnt+1));
                        len[x][y][temp.cnt+1] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
