package stack.queue;

import java.util.ArrayList;
import java.util.Scanner;

public class 백준_2164_카드2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int head = 0;
        int tail = n;
        for(int i=1; i<=n; i++){
            arr.add(i);
        }
        while(true){
            if(tail-head==1){
                System.out.println(arr.get(tail-1));
                break;
            }
            head++;
            int data = arr.get(head);
            head++;
            arr.add(data);
            tail++;
        }
    }
}
