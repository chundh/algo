package UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_11725_트리의부모찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int[] parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.get(x).add(y);
            arr.get(y).add(x);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] check = new boolean[n+1];
        check[1] = true;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for (int next : arr.get(temp)){
                if(!check[next]){
                    check[next] = true;
                    queue.add(next);
                    parent[next] = temp;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
}
