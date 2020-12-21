package stack.queue;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 백준_11003_최솟값찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] val = new int[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(st.nextToken());
            while (!queue.isEmpty() && val[queue.peekLast()] > val[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if(queue.peekFirst() < i-l+1)
                queue.pollFirst();
            sb.append(val[queue.peekFirst()] + " ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
/*
11 4
1 1000 2 3 4 5 6 1001 1002 1003 1004
 */