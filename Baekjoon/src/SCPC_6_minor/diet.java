package SCPC_6_minor;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class diet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
            long Answer = 0;
            int n = sc.nextInt();
            int k = sc.nextInt();
            PriorityQueue<Integer> arr1 = new PriorityQueue<>();
            PriorityQueue<Integer> arr2 = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> arr3 = new PriorityQueue<>();
            PriorityQueue<Integer> arr4 = new PriorityQueue<>(Comparator.reverseOrder());
            for(int i=0; i<n; i++){
                int a = sc.nextInt();
                arr1.add(a);
                arr2.add(a);
            }
            for(int i=0; i<n; i++){
                int a = sc.nextInt();
                arr3.add(a);
                arr4.add(a);
            }
            PriorityQueue<Long> ans_arr1 = new PriorityQueue<Long>(Comparator.reverseOrder());
            PriorityQueue<Long> ans_arr2 = new PriorityQueue<Long>(Comparator.reverseOrder());
            if(n>k){
                for(int i=0; i<n; i++){
                    if(arr2.size() == k){
                        break;
                    }
                    arr2.poll();
                    arr4.poll();
                }
            }
            for(int i=0; i<k; i++){
                ans_arr1.add((long) (arr1.poll() + arr4.poll()));
                ans_arr2.add((long) (arr2.poll() + arr3.poll()));
            }

            Answer = Math.max(ans_arr1.poll(), ans_arr2.poll());
//            long sum_1 = arr1.peek() + arr4.peek();
//            long sum_2 = arr2.peek() + arr3.peek();
//            for(int i=n; i>0; i--){
//                if(i==k){
//                    int a = arr1.poll();
//                    int b = arr4.poll();
//                    sum_1 = a+b;
//                    a = arr2.poll();
//                    b = arr3.poll();
//                    sum_2 = a+b;
//                    Answer = Math.max(sum_1, sum_2);
//                }
//                else if(i<k) {
//                    if(sum_1 > arr1.peek() + arr4.peek())
//                        break;
//                    if(sum_2 > arr2.peek() + arr3.peek())
//                        break;
//                    sum_1 = Math.max(sum_1, arr1.peek() + arr4.peek());
//                    sum_2 = Math.max(sum_2, arr2.peek() + arr3.peek());
//                    Answer = Math.max(sum_1, sum_2);
//                }
//                arr2.poll();
//                arr4.poll();
//            }
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}
