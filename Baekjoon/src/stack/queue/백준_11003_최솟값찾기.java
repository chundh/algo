package stack.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 백준_11003_최솟값찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        Deque<Integer> arr = new LinkedList<>();
        int[] num = new int[n];
        for(int i=0; i<n; i++){
            num[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int data = num[i];
            if(arr.size()<l){
                if(data<min){
                    min = data;
                }
                arr.addLast(data);
                System.out.print(arr.peek() + " ");
            }else{
                int temp = arr.pollFirst();
                arr.addLast(data);
                if(min==temp){
                    min = Integer.MAX_VALUE;
                    Object[] temp_arr = arr.toArray();
                    for(int j=0; j<temp_arr.length; j++){
                        if(min>(int)temp_arr[j]){
                            min = (int) temp_arr[j];
                        }
                    }
                }
                System.out.print(min + " ");
            }
        }
    }
}
