package stack.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Stack;

public class 백준_6549_히스토그램에서큰직사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] data = br.readLine().split(" ");
            long answer = 0;
            if(Integer.parseInt(data[0]) == 0)
                return;
            Stack<Integer> stack = new Stack<>();
            long[] arr = new long[data.length-1];
            for(int i=1; i<data.length; i++){
                arr[i-1] = Long.parseLong(data[i]);
            }
            for(int i=0; i<arr.length; i++){
                while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                    long height = arr[stack.pop()];
                    int width = i;
                    if(!stack.isEmpty()) {
                        width = i-stack.peek()-1;
                    }
                    answer = Math.max(answer, width*height);
                }
                stack.push(i);
            }
            while(!stack.isEmpty()){
                long height = arr[stack.pop()];
                int width = arr.length;
                if(!stack.isEmpty()) {
                    width = arr.length-stack.peek()-1;
                }
                answer = Math.max(answer, width*height);
            }
            System.out.println(answer);
        }

    }
}
/*
7 6 5 4 3 2 1 11
0

3 1000000000 1000000000 1000000000
0
 */