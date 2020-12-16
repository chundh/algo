package UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class น้มุ_11438_LCA2 {
    static int[] parent;
    static ArrayList<Integer> arr1;
    static ArrayList<Integer> arr2;

    public static int find(int v){
        if(parent[v] == v)
            return v;
        return find(parent[v]);
    }
    public static int find1(int v){
        arr1.add(v);
        if(parent[v] == v)
            return v;
        return find1(parent[v]);
    }
    public static int find2(int v){
        arr2.add(v);
        if(parent[v] == v)
            return v;
        return find2(parent[v]);
    }
    public static void union(int u, int v){
        if(parent[u] == parent[v])
            return;
        int v1 = find(u);
        int v2 = find(v);
        if(v1==v2)
            return;
        if(v1<v2){
            parent[v] = u;
        }else
            parent[u] = v;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr1 = new ArrayList<>();
        arr2 = new ArrayList<>();
        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            union(v1, v2);
        }
//        for (int i = 1; i <= n; i++) {
//            System.out.println(i + " : " + parent[i]);
//        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            arr1.clear();
            arr2.clear();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            find1(v1);
            find2(v2);
            int idx1 = 0;
            int idx2 = 0;
            while(true){
                if(idx1==arr1.size() && idx2==arr2.size())
                    break;
                if(idx1==arr1.size()){
                    for (int j = idx2; j < arr2.size(); j++) {
                        if(arr1.get(idx1-1) == arr2.get(j)){
                            System.out.println(arr2.get(j));
                            break;
                        }
                    }
                    break;
                }
                if(idx2 == arr2.size()){
                    for (int j = idx1; j < arr1.size(); j++) {
                        if(arr2.get(idx2-1) == arr1.get(j)){
                            System.out.println(arr1.get(j));
                            break;
                        }
                    }
                    break;
                }
                if(arr1.get(idx1).equals(arr2.get(idx2))){
                    System.out.println(arr1.get(idx1));
                    break;
                }
                if(arr1.get(idx1) > arr2.get(idx2)){
                    idx1++;
                }else{
                    idx2++;
                }
            }
        }
    }
}
