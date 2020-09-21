package Dynamic_Programming;

import java.util.*;

public class baek_1005 {
    static int[] arr;
    static int ans;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc=0; tc<t; tc++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            List<List<Integer>> array = new ArrayList<List<Integer>>();
            int[] indegree = new int[n+1];
            for(int i=0; i<=n; i++){
                array.add(new ArrayList<>());
                indegree[i] = 0;
            }
            arr= new int[n+1];
            for(int i=1; i<=n; i++){
                arr[i] = sc.nextInt();
            }
            for(int i=0; i<k; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                array.get(a).add(b);
                indegree[b]++;
            }
            ans = sc.nextInt();
            int[] dp = new int[n+1];
            topologicalSort(indegree, array, dp);
        }
    }
    static void topologicalSort(int[] indegree, List<List<Integer>> array, int[] time) {
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> result = new LinkedList<Integer>();

        // ť�� indegree �� 0 �� ��� ���
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                time[i] = arr[i];
            }
        }
        /**
         * 1. ť���� ���� ������ �ش� ��尡 ����Ű�� ����� indegree �� 1 ����
         * 2. ���� indegree�� 0 �� �ȴٸ� ť�� �ֱ�
         * 3. ť�� �������� �ݺ�
         */
        while (!q.isEmpty()) {
            int node = q.poll();
            result.offer(node);
            for (Integer i : array.get(node)) {
                indegree[i]--;
                time[i] = Math.max(time[i], time[node]+arr[i]);
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }
        System.out.println(time[ans]);
    }

}