package 시뮬레이션;

import java.util.ArrayList;
import java.util.Scanner;

public class 백준_15683_감시 {
    static class spot{
        int x;
        int y;

        public spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx;
    static int[] dy;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        int blank_cnt = 0;
        int camera_cnt=0;
        ArrayList<spot> camera_spot = new ArrayList<>();
        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 0)
                    blank_cnt++;
                else if(arr[i][j] == 6)
                    continue;
                else{
                    camera_cnt++;
                    camera_spot.add(new spot(i,j));
                }
            }
        }
        int for_cnt = 3;
        int mp4 = 4;
        for(int i=0; i<camera_cnt-1; i++){
            for_cnt += mp4 * 3;
            mp4*=4;
        }
        int answer = 0;
        for(int i=0; i<=for_cnt; i++){
            int temp = i;
            int[] direction = new int[camera_cnt];
            for(int j=0; j<camera_cnt; j++){
                direction[j] = temp%4;
                temp/=4;
            }
            int[][] board = new int[arr.length][arr[0].length];
            int max = 0;
            for(int j=0; j<camera_cnt; j++){
                spot temp_spot = camera_spot.get(j);
                if(arr[temp_spot.x][temp_spot.y]==1){
                    max += fill(arr, camera_spot.get(j).x, camera_spot.get(j).y, direction[j], board);
                } else if (arr[temp_spot.x][temp_spot.y]==2) {
                    max += fill(arr, camera_spot.get(j).x, camera_spot.get(j).y, direction[j], board);
                    max += fill(arr, camera_spot.get(j).x, camera_spot.get(j).y, direction[j]+2, board);
                }else if(arr[temp_spot.x][temp_spot.y]==3){
                    max += fill(arr, camera_spot.get(j).x, camera_spot.get(j).y, direction[j], board);
                    max += fill(arr, camera_spot.get(j).x, camera_spot.get(j).y, direction[j]+1, board);
                }else if(arr[temp_spot.x][temp_spot.y]==4){
                    max += fill(arr, camera_spot.get(j).x, camera_spot.get(j).y, direction[j], board);
                    max += fill(arr, camera_spot.get(j).x, camera_spot.get(j).y, direction[j]+1, board);
                    max += fill(arr, camera_spot.get(j).x, camera_spot.get(j).y, direction[j]+2, board);
                }else{
                    max += fill(arr, camera_spot.get(j).x, camera_spot.get(j).y, direction[j], board);
                    max += fill(arr, camera_spot.get(j).x, camera_spot.get(j).y, direction[j]+1, board);
                    max += fill(arr, camera_spot.get(j).x, camera_spot.get(j).y, direction[j]+2, board);
                    max += fill(arr, camera_spot.get(j).x, camera_spot.get(j).y, direction[j]+3, board);
                }
            }
            answer = Math.max(answer, max);
        }
        System.out.println(blank_cnt-answer);
    }

    public static int fill(int[][] arr, int x, int y, int flag, int[][] board){
        flag %= 4;
        int cnt=0;
        while(true){
            int temp_x = x + dx[flag];
            int temp_y = y + dy[flag];
            x = temp_x;
            y = temp_y;
            if(temp_x<0 || temp_x>=arr.length || temp_y<0 || temp_y>=arr[0].length)
                break;
            if(arr[temp_x][temp_y] == 0){
                if(board[x][y] == 0){
                    board[x][y] = 7;
                    cnt++;
                }
            }else if(arr[temp_x][temp_y]==6){
                break;
            }
        }
        return cnt;
    }
}
