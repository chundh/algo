package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14503_로봇청소기 {
    static int[][] map;
    static int[][] check;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static class robot{
        int x;
        int y;
        int opt;
        int flag=0;
        public robot(int x, int y, int opt) {
            this.x = x;
            this.y = y;
            this.opt = opt;
        }
        public void checkMap(){
            int temp_opt = this.opt;
            temp_opt--;
            if(temp_opt<0)
                temp_opt=3;
            int tempx = this.x + dx[temp_opt];
            int tempy = this.y + dy[temp_opt];
            if(map[tempx][tempy] == 0 && check[tempx][tempy]==0){ // 현재 기준 왼쪽 구역이 청소가 안되어있고, 비어있는 공간인 경우
                this.x = tempx;
                this.y = tempy;
                this.opt = temp_opt;
                this.flag=0;
            }else{
                this.opt = temp_opt;
                this.flag++;
                if(this.flag==4){ // 네방향 모두 청소가 되어있거나 벽인 경우
                    int idx = (this.opt+2)%4;
                    if(map[this.x+dx[idx]][this.y+dy[idx]]==1){ // 뒤가 벽인 경우
                        this.flag=5;
                    }else{
                        this.flag=0;
                        this.x += dx[idx];
                        this.y += dy[idx];
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        check = new int[n][m];
        st = new StringTokenizer(br.readLine());
        robot robot = new robot(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        for (int i = 0; i < n; i++) {
            String[] d = br.readLine().split(" ");
            for (int j = 0; j < d.length; j++) {
                map[i][j] = Integer.parseInt(d[j]);
            }
        }

        while(true){
            check[robot.x][robot.y] = 1;
            robot.checkMap();
            if(robot.flag==5){
                break;
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(check[i][j] == 1)
                    answer++;
            }
        }
        System.out.println(answer);
    }
}
