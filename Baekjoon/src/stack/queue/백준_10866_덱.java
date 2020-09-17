package stack.queue;

import java.util.Scanner;

public class น้มุ_10866_ตฆ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int head = n/2;
        int tail = n/2;
        for(int i=0; i<n; i++){
            String order = sc.next();
            if(order.equals("push_front")){
                int data = sc.nextInt();
                arr[head] = data;
                head--;
            }else if(order.equals("push_back")){
                int data = sc.nextInt();

            }else if(order.equals("pop_front")){
                int data = sc.nextInt();
                tail++;
            }else if(order.equals("pop_back")){
                int data = sc.nextInt();

            }else if(order.equals("empty")){
                if(head<tail){
                    System.out.println(0);
                }else{
                    System.out.println(1);
                }
            }else if(order.equals("front")){
                if(head<tail) {
                } else {
                    System.out.println(-1);
                }
            } else if(order.equals("back")){
                if(head<tail) {
                } else {
                    System.out.println(-1);
                }
            } else if(order.equals("size")){
                System.out.println(tail-head);
            }
        }
    }
}
