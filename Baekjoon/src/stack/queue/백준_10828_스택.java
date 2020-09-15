package stack.queue;

import java.util.ArrayList;
import java.util.Scanner;

public class 백준_10828_스택 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        int idx = 0;
        for(int i=0; i<n; i++){
            String order = sc.next();
            if(order.equals("push")){
                int data = sc.nextInt();
                arr.add(data);
                idx++;
            }else if(order.equals("pop")){
                if (arr.size() != 0) {
                    System.out.println(arr.get(arr.size()-1));
                    arr.remove(arr.size()-1);
                }else{
                    System.out.println(-1);
                }
            }else if(order.equals("empty")){
                if(arr.size()==0){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if(order.equals("top")){
                if(arr.size()!=0) {
                    System.out.println(arr.get(arr.size() - 1));
                } else {
                    System.out.println(-1);
                }
            } else if(order.equals("size")){
                System.out.println(arr.size());
            }
        }
    }
}
