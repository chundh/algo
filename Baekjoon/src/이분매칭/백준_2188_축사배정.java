package 이분매칭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_2188_축사배정 {
    static boolean[] visit;
    static int[] val;
    static ArrayList<ArrayList<Integer>> arr;
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
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            visit = new boolean[m+1];
            if(check(i)){
                answer++;
            }
        }
        System.out.println(answer);
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        int[] visit = new int[m+1];
//        PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue<>(new Comparator<ArrayList<Integer>>() {
//            @Override
//            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
//                return o1.size()-o2.size();
//            }
//        });
//        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            arr.add(new ArrayList<>());
//            st = new StringTokenizer(br.readLine());
//            int t = Integer.parseInt(st.nextToken());
//            for (int j = 0; j < t; j++) {
//                int temp = Integer.parseInt(st.nextToken());
//                visit[temp]++;
//                arr.get(i).add(temp);
//            }
//            queue.add(arr.get(i));
//        }
//        int answer = 0;
//        while(!queue.isEmpty()){
//            ArrayList<Integer> temp = queue.poll();
//            int min = Integer.MAX_VALUE;
//            int min_idx = -1;
//            for(int next : temp){
//                if(visit[next]==0)
//                    continue;
//                if(min > visit[next]) { // 축사를 원하는 소의 수가 가장 작은 축사를 선택해야한다.
//                    min = visit[next];
//                    min_idx = next;
//                }
//                visit[next]--;
//            }
//            if(min!=Integer.MAX_VALUE){
//                visit[min_idx] = 0;
//                answer++;
//            }
//        }
//        System.out.println(answer);
//    }
}