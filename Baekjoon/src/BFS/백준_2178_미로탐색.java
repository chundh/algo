package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 시작지점에서 종료지점까지의 최단거리를 알 수 있다.
 **/

public class 백준_2178_미로탐색 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            String d = sc.next();
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(d.substring(j,j+1));
            }
        }
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        boolean[][] check = new boolean[n][m];
        int[][] len = new int[n][m];
        Queue<spot> spot = new LinkedList<>();
        spot.add(new spot(0,0));
        check[0][0] = true;
        len[0][0] = 0;
        int answer = 0;
        while(true){
            if(spot.isEmpty())
                break;
            answer++;
            spot temp_spot = spot.poll();
            int x = temp_spot.x;
            int y = temp_spot.y;
            if(x==n-1 && y == m-1){
                break;
            }
            int cnt = spot.size();
            for(int i=0; i<4; i++){
                int temp_x = x + dx[i];
                int temp_y = y + dy[i];
                if(temp_x>=arr.length || temp_x<0 || temp_y>=arr[0].length || temp_y<0)
                    continue;
                if(arr[temp_x][temp_y]==1 && !check[temp_x][temp_y]){
                    spot.add(new spot(temp_x, temp_y));
                    check[temp_x][temp_y] = true;
                    len[temp_x][temp_y] = len[x][y]+1;
                }
            }
            if(cnt==spot.size())
                answer--;
        }
        System.out.println(len[n-1][m-1]+1);
    }
}
