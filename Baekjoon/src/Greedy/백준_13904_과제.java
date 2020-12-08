package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_13904_과제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            arr.add(new ArrayList<>());
        }
        int max_day = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.get(d).add(w);
            max_day = Math.max(max_day, d);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int count = 0;
        for (int i = 0; i <= max_day; i++) {
            count = i;
            if(arr.get(i).size()!=0){
                for (int j = 0; j < arr.get(i).size(); j++) {
                    queue.add(arr.get(i).get(j));
                }
            }
            while (queue.size()>count){
                queue.poll();
            }
        }
        int answer = 0;
        while(!queue.isEmpty()){
            answer += queue.poll();
        }
        System.out.println(answer);
    }
}

/*
7
4 60
4 40
1 20
2 50
3 30
4 10
6 5

7
100 10000
100 40
100 20
2 50
3 30
4 10
6 5
 */