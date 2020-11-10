package CodingTest.Ä«Ä«¿À2020ÀÎÅÏ½Ê;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class µ¿±¼Å½Çè {
    public static void main(String[] args) {
        int n = 9;
        int[][] path = {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        int[][] order = {{8,5},{6,7},{4,1}};
//        int[][] path = {{0,1},{0,3},{0,7}};
//        int[][] order = {{1,3},{3,7},{7,1}};
        System.out.println(solution(n, path, order));
    }
    public static boolean solution(int n, int[][] path, int[][] order){
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int[] orderinfo = new int[200001];
        int[] len = new int[n];
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < path.length; i++) {
            int v1 = path[i][0];
            int v2 = path[i][1];
            arr.get(v1).add(v2);
            arr.get(v2).add(v1);
        }
        for (int i = 0; i < order.length; i++) {
            int v1 = order[i][0];
            int v2 = order[i][1];
            if(v1==0)
                continue;
            orderinfo[v1] = v2;
            len[v2]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visit = new boolean[n];
        visit[0] = true;
        int flag=0;
        int cnt = 0;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            if(flag==1){
                cnt++;
                if(cnt>= queue.size()+1){
                    return false;
                }
            }
            if(len[temp]!=0) {
                queue.add(temp);
                flag=1;
                continue;
            }
            flag=0;
            cnt=0;
            for (int next : arr.get(temp)){
                if(len[next]==0){
                    if(orderinfo[next]!=0){
                        len[orderinfo[next]]--;
                        orderinfo[next] = 0;
                    }
                }
                if(!visit[next]){
                    queue.add(next);
                    visit[next]=true;
                }
            }
        }
        return true;
    }
}
