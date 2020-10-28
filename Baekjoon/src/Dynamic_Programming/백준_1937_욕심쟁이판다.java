package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * dfs�� �����ϸ鼭 �̹� �湮�� �����̸� �ش� dp[x][y]�� ���� ��ȯ�Ͽ� �ð� ����!!
 */

public class ����_1937_��������Ǵ� {
    static int[][] dp;
    static int[][] map;
    static int[] dx;
    static int[] dy;
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
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};
        for(int i=0; i<n; i++){
            String[] data = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(data[j]);
                dp[i][j] = -1;
            }
        }
        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                answer = Math.max(answer, dfs(i,j));
            }
        }
        System.out.println(answer);
    }
    public static int dfs(int x, int y){
        if(dp[x][y] != -1){
            return dp[x][y];
        }
        dp[x][y] = 1;
        int data = 0;
        for(int i=0; i<4; i++){
            int temp_x = x + dx[i];
            int temp_y = y + dy[i];
            if(temp_x>=dp.length || temp_x<0 || temp_y>=dp.length || temp_y<0)
                continue;
            else {
                if(map[temp_x][temp_y] > map[x][y])
                    data = Math.max(data, dfs(temp_x, temp_y));
            }
        }
        dp[x][y] += data;
        return dp[x][y];
    }
}
