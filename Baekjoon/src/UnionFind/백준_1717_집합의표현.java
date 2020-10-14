package UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1717_집합의표현 {
    static int[] parent;
    public static int find(int u){
        if(parent[u] == u){
            return u;
        }
        return parent[u] = find(parent[u]);
    }
    public static void union(int u, int v){
        int v1 = find(u);
        int v2 = find(v);
        if(v1 == v2)
            return;
        int min = Math.min(v1, v2);
        parent[v1] = min;
        parent[v2] = min;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int opt = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            if(opt==0){
                union(v1, v2);
            }else{
                if(find(v1) == find(v2)){
                    System.out.println("YES");
                }else
                    System.out.println("NO");
            }
        }
    }
}
