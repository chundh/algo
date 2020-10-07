package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class น้มุ_1600_ฟ๘ผþภฬ {
    static int answer = Integer.MAX_VALUE;
    static class info{
        int x;
        int y;
        int count;
        int horse;

        public info(int x, int y, int count, int horse) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.horse = horse;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][] arr = new int[h][w];
        for(int i=0; i<h; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int[] hx = {-1,-2,-1,-2,1,2,1,2};
        int[] hy = {-2,-1,2,1,-2,-1,2,1};
        boolean[][][] check = new boolean[h][w][31];
        info info = new info(0,0,0,k);
        Queue<info> queue = new LinkedList<>();
        queue.add(info);

        while(!queue.isEmpty()){
            info temp = queue.poll();
            int x = temp.x;
            int y = temp.y;
            if(x==h-1 && y == w-1){
                System.out.println(temp.count);
                return;
            }
            if(x<0 || x>=arr.length || y<0 || y>=arr[0].length) continue;
            if(arr[x][y] == 1) continue;
            if(check[x][y][temp.horse]) continue;

            check[x][y][temp.horse] = true;
            for(int i=0; i<4; i++){
                int temp_x = x + dx[i];
                int temp_y = y + dy[i];
                info temp_info = new info(temp_x, temp_y, temp.count+1, temp.horse);
                queue.add(temp_info);
            }
            if(temp.horse!=0){
                for(int i=0; i<8; i++){
                    int temp_x = x+hx[i];
                    int temp_y = y+hy[i];
                    info temp_info = new info(temp_x, temp_y, temp.count+1, temp.horse-1);
                    queue.add(temp_info);
                }
            }
        }
        System.out.println(-1);
    }
}
/*
4
        6 10
        0 0 1 1 1 1
        0 1 1 0 1 1
        0 1 1 1 1 0
        0 1 1 1 1 0
        0 1 1 1 1 0
        0 1 1 1 1 0
        0 1 1 0 1 1
        0 1 1 1 1 1
        1 1 1 1 0 0
        1 0 0 1 1 0
        ->10

1
4 4
0 1 1 1
0 0 1 1
1 0 1 1
1 1 1 0
->4
        */