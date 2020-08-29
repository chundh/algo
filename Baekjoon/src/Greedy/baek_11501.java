package Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class baek_11501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 0; tc<t; tc++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            PriorityQueue<Integer> data = new PriorityQueue<>(Comparator.reverseOrder());
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
                data.add(arr[i]);
            }
            long answer = 0;
            int max = data.poll();
//            for(int i=0; i<n; i++){
//                if(arr[i]<max){
//                    answer += max - arr[i];
//                }
//                else if(arr[i] >= max){
//                    if(data.isEmpty()) {
//                        break;
//                    }
//                    max = data.poll();
//                }
//            }
            max = 0;
            for(int i=n-1; i>=0; i--){
                if(arr[i]>=max){
                    max = arr[i];
                }
                else{
                    answer += max - arr[i];
                }
            }
            System.out.println(answer);
        }
    }
}
