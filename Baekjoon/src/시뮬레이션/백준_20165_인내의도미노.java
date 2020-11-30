package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_20165_인내의도미노 {
    static int[][] origin;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        String[][] map = new String[n+1][m+1];
        origin = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String[] d = br.readLine().split(" ");
            for (int j = 1; j <= d.length; j++) {
                map[i][j] = d[j-1];
                origin[i][j] = Integer.parseInt(d[j-1]);
            }
        }
        for (int i = 0; i < r; i++) {
            String[] d = br.readLine().split(" ");
            int x = Integer.parseInt(d[0]);
            int y = Integer.parseInt(d[1]);
            String opt = d[2];
            attack(map, x, y, opt);
            d = br.readLine().split(" ");
            x = Integer.parseInt(d[0]);
            y = Integer.parseInt(d[1]);
            def(map, x, y);
        }
        System.out.println(answer);
        print(map);
    }
    public static void attack(String[][] map, int x, int y, String opt){
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int idx = 0;
        if(opt.equals("N")) idx=0;
        else if(opt.equals("E")) idx = 1;
        else if(opt.equals("S")) idx = 2;
        else idx = 3;
        int cnt = 0;
        while(true){
            if(x<1 || y<1 || x>=map.length || y>=map[0].length)
                break;
            if(cnt<0)
                break;
            if(map[x][y].equals("F")) {
                cnt--;
                x += dx[idx];
                y += dy[idx];
                continue;
            }
            else {
                if (Integer.parseInt(map[x][y]) - 1 > cnt) {
                    cnt = Integer.parseInt(map[x][y]) - 1;
                }
                answer++;
                map[x][y] = "F";
                cnt--;
                x += dx[idx];
                y += dy[idx];
            }
        }
    }
    public static void def(String[][] map, int x, int y){
        map[x][y] = String.valueOf(origin[x][y]);
    }
    public static void print(String[][] map){
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                if(!map[i][j].equals("F"))
                    System.out.print("S ");
                else
                    System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
