package stack.queue;

import java.util.Scanner;
import java.util.Stack;

public class 백준_2504_괄호의값 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String d = sc.next();
        Stack<String> arr = new Stack<>();
        int answer = 0;
        int flag=0;
        for(int i=0; i<d.length(); i++){
            if(flag==1){
                break;
            }
            String data = d.substring(i, i+1);
            if(data.equals("(")){
                arr.add(data);
            }else if(data.equals("[")){
                arr.add(data);
            }else if(data.equals(")")){
                int num = 0;
                while(true){
                    if(arr.size()==0){
                        answer = 0;
                        flag = 1;
                        break;
                    }
                    String temp = arr.pop();
                    if(temp.equals("(")){
                        if(num==0){
                            num += 2;
                        }else{
                            num *= 2;
                        }
                        arr.add(String.valueOf(num));
                        break;
                    }
                    else if(temp.equals("[")){
                        answer = 0;
                        flag = 1;
                        break;
                    }
                    else{
                        num += Integer.parseInt(temp);
                    }
                }
            }else if(data.equals("]")){
                int num = 0;
                while(true){
                    if(arr.size()==0){
                        answer = 0;
                        flag = 1;
                        break;
                    }
                    String temp = arr.pop();
                    if(temp.equals("[")){
                        if(num==0){
                            num += 3;
                        }else{
                            num *= 3;
                        }
                        arr.add(String.valueOf(num));
                        break;
                    }
                    else if(temp.equals("(")){
                        answer = 0;
                        flag = 1;
                        break;
                    }else{
                        num += Integer.parseInt(temp);
                    }
                }
            }else{
                flag=1;
                answer = 0;
                break;
            }
        }
        int len = arr.size();
        if(flag!=1) {
            while(!arr.isEmpty()){
                String temp = arr.pop();
                if(temp.equals("(") || temp.equals("[")){
                    answer = 0;
                    break;
                }
                answer += Integer.parseInt(temp);
            }
        }
        System.out.println(answer);
    }
}
