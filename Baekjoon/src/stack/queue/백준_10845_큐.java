package stack.queue;

import java.util.ArrayList;
import java.util.Scanner;

public class น้มุ_10845_ลฅ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        int head=0;
        int tail=0;
        for(int i=0; i<n; i++){
            String order = sc.next();
            if(order.equals("push")){
                int data = sc.nextInt();
                arr.add(data);
                tail++;
            }else if(order.equals("pop")){
                if (head<tail) {
                    System.out.println(arr.get(head));
                    head++;
                }else{
                    System.out.println(-1);
                }
            }else if(order.equals("empty")){
                if(head<tail){
                    System.out.println(0);
                }else{
                    System.out.println(1);
                }
            }else if(order.equals("front")){
                if(head<tail) {
                    System.out.println(arr.get(head));
                } else {
                    System.out.println(-1);
                }
            } else if(order.equals("back")){
                if(head<tail) {
                    System.out.println(arr.get(tail-1));
                } else {
                    System.out.println(-1);
                }
            } else if(order.equals("size")){
                System.out.println(tail-head);
            }
        }
    }
}
