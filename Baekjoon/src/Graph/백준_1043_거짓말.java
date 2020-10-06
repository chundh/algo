package Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class πÈ¡ÿ_1043_∞≈¡˛∏ª {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        if(k==0){
            System.out.println(m);
        }else {
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            boolean[] check = new boolean[n+1];
            while(st.hasMoreTokens()){
                int temp = Integer.parseInt(st.nextToken());
                check[temp] = true;
            }
            for(int i=0; i<=n; i++){
                arr.add(new ArrayList<>());
            }
            int[][] question = new int[m][];
            for(int tc=0; tc<m; tc++){
                st = new StringTokenizer(br.readLine());
                int cnt = Integer.parseInt(st.nextToken());
                question[tc] = new int[cnt];
                int[] check_arr = new int[cnt];
                for(int i=0; i<cnt; i++){
                    check_arr[i] = Integer.parseInt(st.nextToken());
                    question[tc][i] = check_arr[i];
                }
                for(int i=0; i<cnt; i++){
                    for(int j=i+1; j<cnt; j++){
                        arr.get(check_arr[i]).add(check_arr[j]);
                        arr.get(check_arr[j]).add(check_arr[i]);
                    }
                }
            }
            Queue<Integer> queue = new LinkedList<>();
            for(int i=1; i<n; i++){
                if(check[i]){
                    queue.add(i);
                }
            }
            while(!queue.isEmpty()){
                int temp = queue.poll();
                for(int next : arr.get(temp)){
                    if(!check[next]){
                        queue.add(next);
                        check[next] = true;
                    }
                }
            }
            int answer = 0;
            for(int i=0; i<question.length; i++){
                int flag=0;
                for(int j=0; j<question[i].length; j++){
                    if(check[question[i][j]]){
                        flag=1;
                        break;
                    }
                }
                if(flag==0){
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }
}