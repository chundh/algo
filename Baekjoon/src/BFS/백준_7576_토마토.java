package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_7576_토마토 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[n][m];
        Queue<spot> queue = new LinkedList<>();
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int answer = 0;
        int idx = 0;
        boolean[][] check = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j] ==1){
                    queue.add(new spot(i,j));
                    check[i][j] = true;
                }else if(arr[i][j]==-1){
                    check[i][j] = true;
                }
            }
        }
        int q_size = queue.size();
        while(true){
            if(queue.isEmpty()){
                break;
            }
            if(idx==q_size){
                answer++;
                q_size = queue.size();
                idx = 0;
            }
            spot temp_spot = queue.poll();
            int x = temp_spot.x;
            int y = temp_spot.y;
            for(int i=0; i<4; i++){
                int temp_x = x + dx[i];
                int temp_y = y + dy[i];
                if(temp_x>=arr.length || temp_x<0 || temp_y>=arr[0].length || temp_y<0)
                    continue;
                if(!check[temp_x][temp_y]){
                    queue.add(new spot(temp_x, temp_y));
                    arr[temp_x][temp_y] = 1;
                    check[temp_x][temp_y] = true;
                }
            }
            idx++;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!check[i][j]){
                    answer = -1;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
