package stack.queue;

import java.util.ArrayList;
import java.util.Scanner;

public class 백준_10773_제로 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<k; i++){
            int n = sc.nextInt();
            if(n==0){
                arr.remove(arr.size()-1);
            }else {
                arr.add(n);
            }
        }
        int answer = 0;
        for(int i=0; i<arr.size(); i++){
            answer += arr.get(i);
        }
        System.out.println(answer);
    }
}
