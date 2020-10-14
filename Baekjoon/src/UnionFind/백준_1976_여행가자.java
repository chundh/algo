package UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1976_여행가자 {
    static int[] parent;
    static int find(int u){
        if(parent[u] == u)
            return u;
        return parent[u] = find(parent[u]);
    }
    static void union(int u, int v){
        int v1 = find(u);
        int v2 = find(v);
        if(v1 == v2) {
            return;
        }
        int min = Math.min(v1,v2);
        parent[v1] = min;
        parent[v2] = min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1){
                    if(find(i) != find(j)){
                        union(i,j);
                    }
                }
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int len = parent[d];
        while (st.hasMoreTokens()){
            int data = Integer.parseInt(st.nextToken());
            if(parent[data] != len){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
