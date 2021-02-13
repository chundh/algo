package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2186_문자판 {
    static String[][] arr;
    static int[][] cnt;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static String key;
    static int k;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new String[n][m];
        cnt = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < temp.length; j++) {
                arr[i][j] = temp[j];
                cnt[i][j] = -1;
            }
        }
        key = br.readLine();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < key.length(); l++) {
                    if(arr[i][j].equals(key.substring(l, l+1))){
                        cnt[i][j] = 0;
                        break;
                    }
                }
            }
        }
        dp = new int[n][m][key.length()+1];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j].equals(key.substring(0,1))){
                    answer += dfs(i, j, 1);
                }
            }
        }
        System.out.println(answer);
    }
    public static int dfs(int x, int y, int idx){
        if(dp[x][y][idx]!=0)
            return dp[x][y][idx];
        if(idx==key.length()) {
            dp[x][y][idx]++;
            return 1;
        }
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < 4; j++) {
                int nx = x + i*dx[j];
                int ny = y + i*dy[j];
                if(nx<0 || ny<0 || nx>=arr.length || ny>=arr[0].length)
                    continue;
                if(cnt[nx][ny]!=-1 && arr[nx][ny].equals(key.substring(idx, idx+1))) {
                    ans += dfs(nx, ny, idx+1);
                }
            }
        }
        dp[x][y][idx] += ans;
        return ans;
    }
}
/*
3 3 1
MCO
MOM
DFM
MOM
 */