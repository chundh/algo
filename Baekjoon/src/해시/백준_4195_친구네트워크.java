package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 백준_4195_친구네트워크 {
    static int[] parent;
    static int[] relation;
    public static int find(int u){
        if(u==parent[u]){
            return u;
        }
        return parent[u] = find(parent[u]);
    }
    public static void merge(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            System.out.println(relation[u]);
            return;
        }
        relation[v] += relation[u];
        parent[u] = v;
        System.out.println(relation[v]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0 ; tc<t; tc++){
            int cnt = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            parent = new int[200001];
            relation = new int[200001];
            for(int i=0; i<cnt*2; i++){
                parent[i] = i;
                relation[i] = 1;
            }
            int idx = 0;
            StringTokenizer st;
            for(int i=0; i<cnt; i++){
                st = new StringTokenizer(br.readLine());
                String v1 = st.nextToken();
                String v2 = st.nextToken();
                if(map.get(v1)==null){
                    map.put(v1, idx);
                    idx++;
                }
                if(map.get(v2) == null){
                    map.put(v2, idx);
                    idx++;
                }
                merge(map.get(v1), map.get(v2));
            }
        }
    }
}
