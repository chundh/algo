package stack.queue;

import java.util.Scanner;
import java.util.Stack;

public class 백준_10799_쇠막대기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String d = sc.next();
        Stack<String> arr = new Stack<>();
        int answer = 0;
        for(int i=0; i<d.length(); i++){
            String data = d.substring(i, i+1);
            String left = "";
            if(i!=0){
                left = d.substring(i-1, i);
            }
            if(data.equals("(")){
                arr.add("(");
            }else{
                String temp = arr.pop();
                if(left.equals(")")){
                    answer++;
                }
                else{
                    answer += arr.size();
                }
            }
        }
        System.out.println(answer);
    }
}
