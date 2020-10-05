package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://redbinalgorithm.tistory.com/111
 */

public class ¹éÁØ_5214_È¯½Â {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int[] temp = new int[k];
            for(int j=0; j<k; j++){
                temp[j] = Integer.parseInt(st.nextToken());
            }
            for(int j=0; j<k; j++){
                for(int idx=j+1; idx<k; idx++){
                    arr.get(temp[j]).add(temp[idx]);
                    arr.get(temp[idx]).add(temp[j]);
                }
            }
        }
        boolean[] check = new boolean[n+1];
        int[] len = new int[n+1];
        for (int i = 1; i <= n; i++) {
            len[i] = 100002;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        check[1] = true;
        len[1] = 1;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int next : arr.get(temp)){
                if(!check[next]){
                    queue.add(next);
                    check[next] = true;
                }
                len[next] = Math.min(len[next], len[temp] + 1);
            }
        }
        if(len[n] == 100002)
            System.out.println(-1);
        else
            System.out.println(len[n]);
    }
}
