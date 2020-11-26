package 시뮬레이션;

import java.util.Arrays;
import java.util.Scanner;

/**
 * n의 최대 : 20 -> 한번당 400번 계산
 * 5번이동 가능하므로 5*5*5*5*5 = 3125
 * 완전탐색 가능
 */

public class 백준_12100_2048 {
    static int[] dx;
    static int[] dy;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, 1, 0, -1};
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int cnt=1;
        for (int i = 0; i < 4; i++) {
            recur(arr, i, cnt);
        }
//        recur(arr, 1, 3);

        System.out.println(answer);
    }
    public static void recur(int[][] arr, int idx, int cnt){
        if(cnt>5){ // end state
            return;
        }
        int[][] data = new int[arr.length][arr[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = arr[i][j];
            }
        }
        boolean[][] check = new boolean[arr.length][arr[0].length];
        int[][] map = new int[arr.length][arr[0].length];
        if(idx==0 || idx==3) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    int x = i;
                    int y = j;
                    int num = data[i][j];
                    if(data[i][j]==0)
                        continue;
                    while (true) {
                        x += dx[idx];
                        y += dy[idx];
                        if (x < 0 || x >= data.length || y < 0 || y >= data[0].length) {
                            x -= dx[idx];
                            y -= dy[idx];
                            map[x][y] = num;
                            data[x][y] = num;
                            if(i!=x || j!=y)
                                data[i][j] = 0;
                            answer = Math.max(answer, map[x][y]);
                            break;
                        }
                        if (data[x][y] != 0) {
                            if (data[x][y] == data[i][j] && !check[x][y]) {
                                map[x][y] = num * 2;
                                data[x][y] = map[x][y];
                                data[i][j] = 0;
                                check[x][y] = true;
                                answer = Math.max(answer, map[x][y]);
                                break;
                            } else {
                                x -= dx[idx];
                                y -= dy[idx];
                                map[x][y] = num;
                                data[x][y] = num;
                                if(i!=x || j!=y){
                                    data[i][j] = 0;
                                }
                                answer = Math.max(answer, map[x][y]);
                                break;
                            }
                        }
                    }
                }
            }
        }else{
            for (int i = arr.length-1; i >= 0; i--) {
                for (int j = arr[0].length-1; j >= 0; j--) {
                    int x = i;
                    int y = j;
                    int num = data[i][j];
                    while (true) {
                        x += dx[idx];
                        y += dy[idx];
                        if (x < 0 || x >= data.length || y < 0 || y >= data[0].length) {
                            x -= dx[idx];
                            y -= dy[idx];
                            map[x][y] = num;
                            data[x][y] = num;
                            if(i!=x || j!=y)
                                data[i][j] = 0;
                            answer = Math.max(answer, map[x][y]);
                            break;
                        }
                        if (data[x][y] != 0) {
                            if (data[x][y] == data[i][j] && !check[x][y]) {
                                map[x][y] = num * 2;
                                data[x][y] = map[x][y];
                                data[i][j] = 0;
                                check[x][y] = true;
                                answer = Math.max(answer, map[x][y]);
                                break;
                            } else {
                                x -= dx[idx];
                                y -= dy[idx];
                                map[x][y] = num;
                                data[x][y] = num;
                                if(i!=x || j!=y){
                                    data[i][j] = 0;
                                }
                                answer = Math.max(answer, map[x][y]);
                                break;
                            }
                        }
                    }
                }
            }
        }
//        System.out.println(idx + "방향 - cnt : " + cnt + " ---------------");
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[0].length; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
        recur(map, 0, cnt+1);
        recur(map, 1, cnt+1);
        recur(map, 2, cnt+1);
        recur(map, 3, cnt+1);

    }
}
/*
5
1024 1024 1024 1024 1024
1024 1024 1024 1024 1024
1024 1024 1024 1024 1024
1024 1024 1024 1024 1024
1024 1024 1024 1024 1024
 */