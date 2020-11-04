package Summer_Winter_Coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ¹è´Þ {
    static class data implements Comparable<data>{
        int num;
        int wei;
        public data(int num, int wei) {
            this.num = num;
            this.wei = wei;
        }
        @Override
        public int compareTo(data o) {
            return this.wei - o.wei;
        }
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] road ={{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;
        solution(N, road, K);
    }
    public static int solution(int N, int[][] road, int K){
        ArrayList<ArrayList<data>> arr = new ArrayList<>();
        for(int i=0; i<=N; i++){
            arr.add(new ArrayList<>());
        }
        for (int i=0; i<road.length; i++){
            int v1 = road[i][0];
            int v2 = road[i][1];
            int wei = road[i][2];
            arr.get(v1).add(new data(v2, wei));
            arr.get(v2).add(new data(v1, wei));
        }
        PriorityQueue<data> queue = new PriorityQueue<>();
        queue.add(new data(1, 0));
        int[] len = new int[N+1];
        for (int i = 0; i <= N; i++) {
            len[i] = Integer.MAX_VALUE;
        }
        len[1] = 0;
        while(!queue.isEmpty()){
            data temp = queue.poll();
            if(temp.wei != len[temp.num])
                continue;
            for(data next: arr.get(temp.num)){
                if(len[temp.num]+next.wei < len[next.num]){
                    len[next.num] = len[temp.num] + next.wei;
                    queue.add(new data(next.num, len[next.num]));
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if(len[i]<=K)
                answer++;
        }
        return answer;
    }
}
