package UnionFind;

import java.util.ArrayList;
import java.util.Arrays;

public class ���α׷��ӽ�_��Ʈ��ũ {
    static int[] parent;
    public static void main(String[] args) {
        int n = 6;
        int[][] computers = {{1, 0, 1, 1, 0, 0}, {0, 1, 0, 0, 1, 1}, {1, 0, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}};
        solution(n, computers);
    }
    public static int find(int u){
        if(parent[u] == u){
            return u;
        }
        return parent[u] = find(parent[u]);
    }
    public static void union(int u, int v){
        int v1 = find(u);
        int v2 = find(v);
        if(v1==v2){
            return;
        }
        if(v1<v2){
            parent[v2] = v1;
            find(v);
        }else{
            parent[v1] = v2;
            find(u);
        }
    }
    public static int solution(int n, int[][] computers){
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<computers.length; i++){
            for(int j=0; j<computers[i].length; j++){
                if(i==j)
                    continue;
                if(computers[i][j] == 1){
                    union(i, j);
                }
            }
        }
        // ����� �θ� ������Ʈ�� �ȵ� ��찡 �����Ƿ� �ѹ� find�� ���ָ鼭 �θ� ����
        for(int i=0; i<n; i++){
            find(i);
        }
        for(int i=0; i<parent.length; i++){
            if (!arr.contains(parent[i])) {
                arr.add(parent[i]);
            }
        }
        System.out.println(arr.size());
        return arr.size();
    }
}
