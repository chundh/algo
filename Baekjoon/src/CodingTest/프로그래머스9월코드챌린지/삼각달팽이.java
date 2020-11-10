package CodingTest.프로그래머스9월코드챌린지;

import java.util.Arrays;

public class 삼각달팽이 {
    static int[] dx = {1,0,-1};
    static int[] dy = {0,1,-1};
    static int cnt = 0;
    static int rec = 0;
    public static void main(String[] args) {
        int n = 1000;
        solution(n);
    }
    public static int[] solution(int n){
        int[][] arr = new int[n][];

        for(int i=1; i<=n; i++){
            arr[i-1] = new int[i];
            cnt += i;
        }
        int[][] map = recur(arr, -1, 0, 0, 1);
        int[] answer = new int[cnt];
        int idx = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                answer[idx] = map[i][j];
                idx++;
            }
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
    public static int[][] recur(int[][] arr, int x, int y, int idx, int c){
        int temp_idx = idx%3;
        if(rec == cnt)
            return arr;
        while(true){
            x += dx[temp_idx];
            y += dy[temp_idx];
            if(x>=arr.length || x<0 || y>=arr[x].length || y<0){
                x -= dx[temp_idx];
                y -= dy[temp_idx];
                temp_idx++;
                recur(arr, x, y, temp_idx, c);
                break;
            }
            if(arr[x][y] != 0){
                x -= dx[temp_idx];
                y -= dy[temp_idx];
                temp_idx++;
                recur(arr, x, y, temp_idx, c);
                break;
            }
            arr[x][y] = c;
            c++;
            rec++;
        }

        return arr;
    }
}
