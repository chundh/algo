package �ùķ��̼�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_14890_���� {
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
        // ���� ���� Ž��
        for (int i = 0; i < n; i++) {
            int prev = map[i][0];
            int lcount = 1;
            for (int j = 1; j < n; j++) {
                if (prev == map[i][j])
                    lcount++;
                else{
                    // �������� ���
                    if(prev == map[i][j] + 1){
                        int cnt = 0;
                        int idx = 0;
                        for (int k = j; k < n; k++) {
                            if(map[i][k] == map[i][j]){
                                cnt++;
                                idx = k;
                            }else{
                                break;
                            }
                            if(cnt == l){
                                break;
                            }
                        }
                        if(cnt >= l){
                            j = idx;
                            lcount = 0;
                            prev = map[i][j];
                            if(idx == n-1){
                                answer++;
                                break;
                            }
                        }else
                            break;
                    }else if(prev == map[i][j] - 1){ // �������� ���
                        if(l <= lcount){
                            prev = map[i][j];
                            lcount = 1;
                        }else
                            break;
                    }else{ // �� �� ���� ���
                        break;
                    }
                }
                if(j == n-1) {
                    answer++;
                }
            }
        }
        // ���� ���� Ž��
        for (int i = 0; i < n; i++) {
            int prev = map[0][i];
            int lcount = 1;
            for (int j = 1; j < n; j++) {
                if (prev == map[j][i])
                    lcount++;
                else{
                    // �������� ���
                    if(prev == map[j][i] + 1){
                        int cnt = 0;
                        int idx = 0;
                        for (int k = j; k < n; k++) {
                            if(map[k][i] == map[j][i]){
                                cnt++;
                                idx = k;
                            }else{
                                break;
                            }
                            if(cnt == l){
                                break;
                            }
                        }
                        if(cnt >= l){
                            j = idx;
                            lcount = 0;
                            prev = map[j][i];
                            if(idx==n-1){
                                answer++;
                                break;
                            }
                        }else
                            break;
                    }else if(prev == map[j][i] - 1){ // �������� ���
                        if(l <= lcount){
                            prev = map[j][i];
                            lcount = 1;
                        }else
                            break;
                    }else{ // �� �� ���� ���
                        break;
                    }
                }
                if(j == n-1) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
