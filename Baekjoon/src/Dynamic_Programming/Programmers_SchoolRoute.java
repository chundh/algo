package Dynamic_Programming;

/**
 * Dynamic Programming중 등굣길 문제
 * 출발점 0,0
 * 도착점 n-1, m-1
 * 재귀로 각 위치 파악. 해당 위치 방문한 적이 있으면 return
 * 최단거리는 정해져 있다. m+n-2-1
 * 이 이상 갈 경우 최단거리가 아니므로 return
 */

public class Programmers_SchoolRoute {
    static int m;
    static int n;
    static int[][] puddles;
    static int[][] check;
    static int answer = 0;
    public static void main(String[] args) {
        m = 4;
        n = 3;
        puddles = new int[][]{{2, 2}};
        solution(m, n, puddles);
    }
    public static void solution(int m, int n, int[][] puddles){
        check = new int[n+1][m+1];
        for(int i=0; i<puddles.length; i++){
            check[puddles[i][0]][puddles[i][1]] = -1;
        }
        int[][] arr = new int[n+1][m+1];
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(i==1 && j==1) {
                    arr[i][j] = 1;
                    continue;
                }
                if(check[i][j] == -1)
                    arr[i][j] = 0;
                else
                    arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        System.out.println(arr[n][m]);



        //recur(0, 0);
        //System.out.println(answer%1000000007);
    }

    public static void recur(int x, int y){
        if(x>=n || x<0 || y>=m || y<0)
            return;
        if(x==n-1 && y==m-1){
            answer++;
            return;
        }
        if(check[x][y] == -1)
            return;
        recur(x+1, y);
        recur(x, y+1);
    }
}
