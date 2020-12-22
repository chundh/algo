package 이분매칭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_11376_열혈강호2 {
    static int[] val;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> arr;
    static int[] num;
    public static boolean check(int target){
        for (int i = 0; i < arr.get(target).size(); i++) {
            int temp = arr.get(target).get(i);
            if(visit[temp])
                continue;
            visit[temp]=true;
            if(val[temp]==0 || check(val[temp])){
                val[temp] = target;
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        val = new int[m+1];
        num = new int[n+1];
        arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            for (int j = 0; j < t; j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr.get(i).add(temp);
            }
        }
        for (int i = 1; i <= n; i++) {
            visit = new boolean[m+1];
            check(i);
            visit = new boolean[m+1];
            check(i);
        }
        int answer = 0;
        for (int i = 1; i <= m; i++) {
            if(val[i] != 0){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
/*
2 5
5 1 2 3 4 5
2 1 2
 */