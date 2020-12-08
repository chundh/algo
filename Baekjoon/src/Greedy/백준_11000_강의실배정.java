package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_11000_강의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Integer> data = new PriorityQueue<>();
        int answer = 1;
        for (int i = 0; i < arr.length; i++) {
            if(data.isEmpty()) {
                data.add(arr[i][1]);
                continue;
            }
            if(data.peek()>arr[i][0]){
                data.add(arr[i][1]);
            }else{
                data.poll();
                data.add(arr[i][1]);
            }
            answer = Math.max(answer, data.size());
        }
        System.out.println(answer);
    }
}
/*
3
1 3
2 4
3 5

3
2 4
1 3
1 2

3
2 1000000000
1 1000000000
1 2
 */