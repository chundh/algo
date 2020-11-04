package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_15684_사다리조작 {
    static int n;
    static int m;
    static int h;
    static int[][] map;
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h+1][n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            map[v1][v2] = 1;
            map[v1][v2+1] = -1;
        }
        for(int i=0; i<4; i++){
            recur(1, 0, i);
            if(answer != -1){
                System.out.println(answer);
                return;
            }
        }
        System.out.println(answer);
    }

    public static void recur(int x, int cnt, int limit){
        if(answer!=-1)
            return;
        if(cnt==limit) {
            findResult(map, limit);
            return;
        }
        for(int i=x; i<=h; i++){
            for(int j=1; j<n; j++){
                if(map[i][j]==0 && map[i][j+1]==0){
                    map[i][j] = 1;
                    map[i][j+1] = -1;
                    recur(x, cnt+1, limit);
                    map[i][j] = 0;
                    map[i][j+1] = 0;
                }
            }
        }
    }
    public static boolean findResult(int[][] map, int limit){
        for (int i = 1; i <= n; i++) {
            int x = 1, y = i;
            for (int j = 0; j < h; j++) {
                if (map[x][y] == 1) y++;
                else if (map[x][y] == -1)
                    y--; x++;
            }
            if (y != i) return false;
        }
        answer = limit;
        return true;
    }
}
