package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_20168_골목대장호석기능성 {
    static class data{
        int num;
        int wei;
        int sum;
        int max;
        public data(int num, int wei, int sum, int max) {
            this.num = num;
            this.wei = wei;
            this.sum = sum;
            this.max = max;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<data>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int wei = Integer.parseInt(st.nextToken());
            arr.get(v1).add(new data(v2, wei,0, wei));
        }
        int answer = -1;
        Queue<data> queue = new LinkedList<>();
        queue.add(new data(a, 0, 0, 0));
        while(!queue.isEmpty()){
            data temp = queue.poll();
//            System.out.println(temp.num + " : " + temp.sum + " , " + temp.max);
            if(temp.sum>c){
                continue;
            }
            if(temp.num==b){
                if(answer==-1)
                    answer = temp.max;
                else
                    answer = Math.min(answer, temp.max);
                continue;
            }
            for(data next : arr.get(temp.num)){
                queue.add(new data(next.num, next.wei, temp.sum+next.wei, Math.max(temp.max, next.wei)));
            }
        }
        System.out.println(answer);
    }
}
