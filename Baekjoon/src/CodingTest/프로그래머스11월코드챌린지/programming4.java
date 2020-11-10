package CodingTest.���α׷��ӽ�11���ڵ�ç����;

import java.util.ArrayList;

/**
 * �ڽ��� ���� ���� Ʈ�� ����
 * ��Ʈ ������ Ž���ϸ鼭 �θ� ����� �ڽ� ���� 4�� �̻��� ��忡�� ����.
 * �ش� �θ� ����� �ڽ� ��� �� �ڽ��� ���� ���� ���� 3�� ����� �ڽ� ����� ���� ��.
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
