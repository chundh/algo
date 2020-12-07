package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 백준_9576_책나눠주기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            boolean[] visit = new boolean[n+1];
            int[][] info = new int[m][2];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                info[i][0] = start;
                info[i][1] = end;
            }
            Arrays.sort(info, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1]==o2[1])
                        return o1[0]-o2[0];
                    return o1[1] - o2[1];
                }
            });
            int answer = 0;
            for (int i = 0; i < info.length; i++) {
                int start = info[i][0];
                int end = info[i][1];
                for (int j = start; j <= end; j++) {
                    if(!visit[j]){
                        answer++;
                        visit[j] = true;
                        break;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
/*
1
1000 3
1 1000
1 1000
1 1000

1
5 3
1 1
1 3
2 2

1
4 4
1 2
2 3
3 4
1 3
 */