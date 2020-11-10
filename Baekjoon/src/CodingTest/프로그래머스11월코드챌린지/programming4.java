package CodingTest.프로그래머스11월코드챌린지;

import java.util.ArrayList;

/**
 * 자식의 갯수 기준 트리 생성
 * 루트 노드부터 탐색하면서 부모 노드의 자식 수가 4개 이상인 노드에서 정지.
 * 해당 부모 노드의 자식 노드 중 자식의 수가 가장 많은 3개 노드의 자식 노드의 합이 답.
 */

public class programming4 {
    static int[] len;
    static int answer;
    public static void main(String[] args) {
        int[][] t = {{2,5},{2,0},{3,2},{4,2},{2,1}};
//        int[][] t = {{5,1},{2,5},{3,5},{3,6},{2,4},{4,0}};
        solution(t);
    }
    public static void solution(int[][] t){
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        len = new int[t.length+1];
        for (int i = 0; i <= t.length; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < t.length; i++) {
            int v1 = t[i][0];
            int v2 = t[i][1];
            arr.get(v1).add(v2);
            arr.get(v2).add(v1);
            len[v1]++;
            len[v2]++;
        }
        for (int i = 0; i < len.length; i++) {
            if(len[i]==1){
                int[] count = new int[t.length+1];
                int data = 0;
                len[i] = -1;
                answer = Math.max(answer, dfs(arr, i, count));
            }
        }
        System.out.println(answer);
    }
    public static int dfs(ArrayList<ArrayList<Integer>> arr, int start, int[] count){
        if(len[start]==1){
            count[start]++;
            return 1;
        }
        count[start]++;
        int ans = 1;
        if (arr.get(start).size()>3){

        }
        for (int next : arr.get(start)){
            if(next==start)
                continue;
            if (count[start]>2){
                return -1;
            }
            if(count[next]==0){
                int sample = dfs(arr, next, count);
                if(sample==-1){
                    return -1;
                }
                ans += sample;
                count[start]++;
            }
        }
        return ans;
    }
}
