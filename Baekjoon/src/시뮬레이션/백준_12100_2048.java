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
        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int cnt=1;
        boolean[][] check = new boolean[n][n];
        recur(arr, 0, cnt, check);
        recur(arr, 1, cnt, check);
        recur(arr, 2, cnt, check);
        recur(arr, 3, cnt, check);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(answer);
    }
    public static void recur(int[][] arr, int flag, int cnt, boolean[][] check){
        if(cnt==6) {
            int max = 0;
            for(int i=0; i<arr.length; i++){
                for(int j=0; j<arr.length; j++){
                    max = Math.max(max, arr[i][j]);
                }
            }
            answer = Math.max(max, answer);
            return;
        }
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(arr[i][j] != 0){
                    int x = i;
                    int y = j;
                    while(true){
                        x += dx[flag];
                        y += dy[flag];
                        if(x<0 || y<0 || x>=arr.length || y>=arr.length) {
                            if(arr[x-dx[flag]][y-dy[flag]]==0){
                                arr[x-dx[flag]][y-dy[flag]]=arr[i][j];
                                if(i!=x-dx[flag] || j!=y-dy[flag])
                                    arr[i][j] = 0;
                            }
                            break;
                        }
                        if(arr[x][y]!=0){
                            if(arr[x][y] == arr[i][j]){
                                if(!check[x][y]) {
                                    arr[x][y] = 2 * arr[x][y];
                                    arr[i][j] = 0;
                                    check[x][y] = true;
                                }
                                else{
                                    arr[x-dx[flag]][y-dy[flag]] = arr[i][j];
                                    if(i!=x-dx[flag] || j!=y-dy[flag])
                                        arr[i][j] = 0;
                                }
                            }else{
                                arr[x-dx[flag]][y-dy[flag]] = arr[i][j];
                                if(i!=x-dx[flag] || j!=y-dy[flag])
                                    arr[i][j] = 0;
                            }
                            break;
                        }
                    }
                }
            }
        }
        recur(arr, 0, cnt+1, check);
        recur(arr, 1, cnt+1, check);
        recur(arr, 2, cnt+1, check);
        recur(arr, 3, cnt+1, check);
    }
}
