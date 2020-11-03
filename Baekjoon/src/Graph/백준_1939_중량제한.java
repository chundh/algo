package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_1939_중량제한{
    static class data implements Comparable<data>{
        int end;
        int wei;
        public data(int end, int wei) {
            this.end = end;
            this.wei = wei;
        }

        @Override
        public int compareTo(data o) {
            return this.wei - o.wei;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<data>> arr = new ArrayList<>();
        for(int i=0; i<=n; i++){
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] d = br.readLine().split(" ");
            int v1 = Integer.parseInt(d[0]);
            int v2 = Integer.parseInt(d[1]);
            int wei = Integer.parseInt(d[2]);
            arr.get(v1).add(new data(v2, wei));
            arr.get(v2).add(new data(v1, wei));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        PriorityQueue<data> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.add(new data(start, 0));
        int[] visit = new int[n+1];
        visit[start] = 0;
        int answer = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            data temp = queue.poll();
            if(temp.wei!=0)
                answer = Math.min(answer, temp.wei);
            System.out.println(temp.end + " , " + temp.wei);
            if(temp.end==end)
                break;
            for(data next : arr.get(temp.end)){
                if(visit[next.end]>=next.wei)
                    continue;
                queue.add(next);
                visit[next.end] = next.wei;
            }
        }
        System.out.println(answer);
    }
}
/*
3 3
1 3 6
3 2 5
3 1 5
1 2
 */