package stack.queue;

import java.util.Stack;

public class 코딜리티연습 {
    public static void main(String[] args) {
        String s = "{][}";
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            int temp = s.charAt(i);
            System.out.println(temp);
            if(temp == 40 || temp == 91 || temp == 123){
                stack.push(temp);
            }else{
                if(stack.isEmpty()){
                    System.out.println(0);
                    break;
                }
                int top = stack.pop();
                System.out.println("top : " + top);
                if(top==40){
                    if(temp == 41){
                        continue;
                    }else{
                        System.out.println(0);
                        break;
                    }
                }else{
                    if(temp != top+2){
                        System.out.println(0);
                        break;
                    }
                }
            }
        }
        System.out.println(1);
    }
}
