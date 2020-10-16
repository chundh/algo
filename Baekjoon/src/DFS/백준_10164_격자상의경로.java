package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_10164_격자상의경로 {
    static int ans1 = 0;
    static int ans2 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int x = 0;
        int y = 0;
        int idx = 1;
        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if(idx==k){
                    x = i;
                    y = j;
                }
                arr[i][j] = idx;
                idx++;
            }
        }
        ans1 = dfs(0,0,x,y);
        ans2 = dfs(x,y,n-1,m-1);
        System.out.println(ans1*ans2);
    }
    public static int dfs(int x, int y, int endx, int endy){
        if(x>endx || y>endy)
            return 0;
        if(x==endx && y == endy)
            return 1;
        int cnt = 0;
        cnt += dfs(x+1,y,endx,endy);
        cnt += dfs(x,y+1,endx,endy);
        return cnt;
    }
}
