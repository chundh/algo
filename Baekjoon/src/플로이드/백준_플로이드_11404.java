package 플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_플로이드_11404 {
    public static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i == j) continue;
                map[i][j] = INF;
            }
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            map[s][e] = Math.min(map[s][e],money);
        }
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                     map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i <= n; i++) {
            for(int j=1; j <= n; j++) {
                if(map[i][j] >= INF) sb.append("0 ");
                else sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
