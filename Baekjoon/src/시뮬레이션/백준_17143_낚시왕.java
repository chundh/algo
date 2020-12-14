package Ω√πƒ∑π¿Ãº«;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class πÈ¡ÿ_17143_≥¨Ω√ø’ {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static class info {
        int x;
        int y;
        int val;
        int dir;
        int size;
        public info(int x, int y, int val, int dir, int size) {
            this.x = x;
            this.y = y;
            this.val = val;
            this.dir = dir;
            this.size = size;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        info[][] map = new info[r][c];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            info temp = new info(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1,
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
            map[temp.x][temp.y] = temp;
        }
        int answer = 0;
        for (int i = 0; i < c; i++) {
            answer += findShark(map, i);
            map = moveShark(map);
//            print(map);
//            System.out.println("------");
        }
        System.out.println(answer);
    }
    public static int findShark(info[][] map, int target){
        for (int i = 0; i < map.length; i++) {
            if(map[i][target]!=null){
                int size = map[i][target].size;
                map[i][target] = null;
                return size;
            }
        }
        return 0;
    }
    public static info[][] moveShark(info[][] map){
        info[][] temp = new info[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] != null){
                    move(temp, map[i][j]);
                }
            }
        }
        return temp;
    }
    public static void move(info[][] map, info temp){
        for (int i = 0; i < temp.val; i++) {
            temp.x += dx[temp.dir];
            temp.y += dy[temp.dir];
            if(temp.x < 0 || temp.y < 0 || temp.x >= map.length || temp.y >= map[0].length) {
                temp.dir = changeDir(temp.dir);
                temp.x += dx[temp.dir]*2;
                temp.y += dy[temp.dir]*2;
            }
        }
        if(map[temp.x][temp.y] != null){
            if(map[temp.x][temp.y].size < temp.size)
                map[temp.x][temp.y] = temp;
        }else
            map[temp.x][temp.y] = temp;
    }
    public static int changeDir(int dir){
        if(dir==0)
            return 1;
        else if(dir==1)
            return 0;
        else if(dir==2)
            return 3;
        else
            return 2;
    }
    public static void print(info[][] map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] == null)
                    System.out.print(0);
                else
                    System.out.print(map[i][j].size);
            }
            System.out.println();
        }
    }
}
