package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_17144_미세먼지안녕 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static class point{
        int x;
        int y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] map = new int[r][c];
        int[][] spread_map = new int[r][c];
        Queue<point> queue = new LinkedList<>();
        ArrayList<point> machine = new ArrayList<>();
        for(int i=0; i<r; i++){
            String[] data = br.readLine().split(" ");
            for(int j=0; j<c; j++){
                map[i][j] = Integer.parseInt(data[j]);
                spread_map[i][j] = Integer.parseInt(data[j]);
                if(Integer.parseInt(data[j])==-1){
                    machine.add(new point(i, j));
                }
            }
        }

        for(int time = 0; time<t; time++){
            map = spread_map;
            spread_map = new int[r][c];
            // 미세먼지 확산
            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    if(map[i][j] != 0 && map[i][j] != -1){
                        queue.add(new point(i, j));
                    }
                }
            }
            map[machine.get(0).x][machine.get(0).y] = -1;
            map[machine.get(1).x][machine.get(1).y] = -1;
            while(!queue.isEmpty()){
                point temp =queue.poll();
                spread(map, temp.x, temp.y, spread_map);
            }
            // 공기 청정기 작동
            machine_Oper(spread_map, machine.get(0).x-1, machine.get(0).y, 0, 1, machine.get(0));
            machine_Oper(spread_map, machine.get(1).x+1, machine.get(1).y, 2, -1, machine.get(1));
        }
        // 남은 미세먼지 양 체크
        int answer = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                answer += spread_map[i][j];
            }
        }
        System.out.println(answer);
    }
    public static void spread(int[][] map, int x, int y, int[][] spread_map){
        int cnt = 0;
        for(int i=0; i<4; i++){
            int temp_x = x + dx[i];
            int temp_y = y + dy[i];
            if(temp_x >=map.length || temp_x<0 || temp_y>=map[0].length || temp_y<0){
                continue;
            }else{
                if(map[temp_x][temp_y]==-1)
                    continue;
                spread_map[temp_x][temp_y] += map[x][y]/5;
                cnt++;
            }
        }
        spread_map[x][y] += map[x][y] - map[x][y]/5 * cnt;
    }
    public static void machine_Oper(int[][] map, int x, int y, int idx, int flag, point mac){ // flag 1이면 공기청정기 위, -1이면 아래
        if(x==mac.x && y == map[0].length-1){
            idx += flag;
            if(idx<0)
                idx = 3;
        }
        else if(x== mac.x && y == mac.y)
            return;
        int temp_x = x + dx[idx];
        int temp_y = y + dy[idx];
        if(temp_x >=map.length || temp_x<0 || temp_y>=map[0].length || temp_y<0){
            idx += flag;
            if(idx<0)
                idx = 3;
            machine_Oper(map, x, y, idx, flag, mac);
        }else{
            map[x][y] = map[temp_x][temp_y];
            map[temp_x][temp_y] = 0;
            machine_Oper(map, temp_x, temp_y, idx, flag, mac);
        }
    }
    public static void print(int[][] map){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------");
    }
}
