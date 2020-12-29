package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1967_트리의지름 {
    static boolean[] visit;
    static int n;
    static class info{
        int num;
        int wei;
        public info(int num, int wei) {
            this.num = num;
            this.wei = wei;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<info>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int wei = Integer.parseInt(st.nextToken());
            arr.get(v1).add(new info(v2, wei));
            arr.get(v2).add(new info(v1, wei));
        }
        info temp = check(arr, 1);
        info ans = check(arr, temp.num);
        System.out.println(ans.wei);
    }
    public static info check(ArrayList<ArrayList<info>> arr, int num){
        visit = new boolean[n+1];
        Queue<info> queue = new LinkedList<>();
        queue.add(new info(num, 0));
        int max = Integer.MIN_VALUE;
        int max_num = -1;
        visit[num] = true;
        while(!queue.isEmpty()){
            info temp = queue.poll();
            if(temp.wei > max){
                max = temp.wei;
                max_num = temp.num;
            }
            for(info next : arr.get(temp.num)){
                if(visit[next.num])
                    continue;
                visit[next.num] = true;
                queue.add(new info(next.num , temp.wei + next.wei));
            }
        }
        return new info(max_num, max);
    }
}