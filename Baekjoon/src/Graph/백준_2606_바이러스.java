package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2606_바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            arr.get(v1).add(v2);
            arr.get(v2).add(v1);
        }
        boolean[] check = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;
        queue.add(1);
        check[1] = true;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int next : arr.get(temp)){
                if(check[next])
                    continue;
                else{
                    queue.add(next);
                    check[next] = true;
                    answer++;
                }
            }
        }


        System.out.println(answer);
    }
}
