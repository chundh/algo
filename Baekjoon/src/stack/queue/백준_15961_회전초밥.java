package stack.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_15961_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        int[] arr = new int[n];
        int[] visit = new int[d+1];
        int answer = 0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        for(int i=0; i<n+k; i++){
            int idx = i;
            if(idx>n-1){
                idx %= n;
            }
            if(i<k) {
                if (visit[arr[idx]] != 0) { // 이미 고른 종류인 경우

                } else { // 처음 고르는 경우
                    cnt++;
                }
                visit[arr[idx]]++;
            }
            else{
                if(visit[c] == 0){
                    answer = Math.max(answer, cnt+1);
                }else{
                    answer = Math.max(answer, cnt);
                }
                int temp = arr[i-k];
                visit[temp]--;
                if(visit[temp]==0)
                    cnt--;
                visit[arr[idx]]++;
                if(visit[arr[idx]]==1)
                    cnt++;
            }
        }
        System.out.println(answer);
    }
}
