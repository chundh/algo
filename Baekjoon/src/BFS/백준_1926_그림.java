package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * x,y가 1인 집합의 갯수와 최대 크기를 알 수 있다.
 */

public class 백준_1926_그림 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++)
                arr[i][j] = sc.nextInt();
        }
        int[] dx = {1, 0 , -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<spot> data = new LinkedList<>();
        boolean[][] check = new boolean[n][m];
        int answer = 0;
        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=0 ;j<m; j++){
                if(arr[i][j]==1 && !check[i][j]){
                    data.add(new spot(i,j));
                    check[i][j] = true;
                    answer = Math.max(recur(arr, data, check, dx, dy), answer);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(answer);
    }
    public static int recur(int[][] arr, Queue<spot> data, boolean[][] check, int[] dx, int[] dy){
        int cnt = 0;
        while(true){
            if(data.isEmpty()){
                break;
            }
            spot spot = data.poll();
            cnt++;
            int x = spot.x;
            int y = spot.y;
            for(int i=0; i<4; i++){
                int temp_x = x + dx[i];
                int temp_y = y + dy[i];
                if(temp_x>=arr.length || temp_x<0 || temp_y>=arr[0].length || temp_y<0)
                    continue;
                if(!check[temp_x][temp_y] && arr[temp_x][temp_y]==1){
                    spot temp_spot = new spot(temp_x, temp_y);
                    data.add(temp_spot);
                    check[temp_x][temp_y] = true;
                }
            }
        }
        return cnt;
    }
}
class spot{
    int x;
    int y;

    public spot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}