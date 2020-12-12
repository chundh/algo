package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14890_경사로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int prev = map[i][0];
            int lcount = 1;
            for (int j = 1; j < n; j++) {
                if(map[i][j] != prev){
                    if(map[i][j] > prev){
                        if(map[i][j] != prev+1)
                            break;
                        else{
                            if(lcount<l)
                                break;
                        }
                    }else if(map[i][j] < prev){
                        if(map[i][j] != prev-1)
                            break;
                        else{
                            int cnt = 0;
                            int idx = 0;
                            for (int k = j; k < n; k++) {
                                if(map[i][k] == map[i][j]){
                                    cnt++;
                                    idx = k;
                                }else
                                    break;
                            }
                            if(cnt < l){
                                break;
                            }else{
                                j = idx;
                            }
                        }
                    }
                    lcount = 1;
                    prev = map[i][j];
                }else{
                    lcount++;
                }
                if(j == n-1) {
                    answer++;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int prev = map[0][j];
            int lcount = 1;
            for (int i = 1; i < n; i++) {
                if(map[i][j] != prev){
                    if(map[i][j] > prev){
                        if(map[i][j] != prev+1)
                            break;
                        else{
                            if(lcount<l)
                                break;
                        }
                    }else if(map[i][j] < prev){
                        if(map[i][j] != prev-1)
                            break;
                        else{
                            int cnt = 0;
                            int idx = 0;
                            for (int k = i; k < n; k++) {
                                if(map[k][j] == map[i][j]){
                                    cnt++;
                                    idx = k;
                                }else
                                    break;
                            }
                            if(cnt < l){
                                break;
                            }else{
                                i = idx;
                            }
                        }
                    }
                    lcount = 1;
                    prev = map[i][j];
                }else{
                    lcount++;
                }
                if(i == n-1) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
