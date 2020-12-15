package ½Ã¹Ä·¹ÀÌ¼Ç;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¹éÁØ_2573_ºù»ê {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        while(true){
            int data = findSection(map);
            if(data >= 2){
                System.out.println(answer);
                break;
            } else if(data == 0){
                System.out.println(0);
                break;
            }
            map = melt(map);
            answer++;
        }
    }
    public static int findSection(int[][] map){
        class info{
            int x;
            int y;
            public info(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        boolean[][] check = new boolean[map.length][map[0].length];
        Queue<info> queue = new LinkedList<>();
        int section = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] != 0 && !check[i][j]){
                    section++;
                    queue.add(new info(i, j));
                    check[i][j] = true;
                    while(!queue.isEmpty()){
                        info temp = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = temp.x + dx[k];
                            int y = temp.y + dy[k];
                            if(x < 0 || y<0 || x>=map.length || y>=map[0].length)
                                continue;
                            if(check[x][y] || map[x][y] == 0)
                                continue;
                            queue.add(new info(x,y));
                            check[x][y] = true;
                        }
                    }
                }
            }
        }
        return section;
    }
    public static int[][] melt(int[][] map){
        int[][] newMap = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] != 0){
                    newMap[i][j] = map[i][j] - findVal(map, i, j);
                    if(newMap[i][j] < 0)
                        newMap[i][j] = 0;
                }
            }
        }
        return newMap;
    }
    public static int findVal(int[][] map, int i, int j){
        int val = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if(x < 0 || y<0 || x>=map.length || y>=map[0].length)
                continue;
            if(map[x][y] == 0){
                val++;
            }
        }
        return val;
    }
    public static void print(int[][] map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
