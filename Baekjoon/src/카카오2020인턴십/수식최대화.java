package 카카오2020인턴십;

import java.util.*;

public class 수식최대화 {
    static String ex;
    static long answer;
    public static void main(String[] args) {
        String expression = "2-990-5+2+3*2";
        solution(expression);
    }
    public static long solution(String expression){
        ex = expression;
        ArrayList<String> arr = new ArrayList<>();
        makeFlow(arr);
        System.out.println(answer);
        return answer;
    }
    public static void makeFlow(ArrayList<String> arr){
        if(arr.size()==3){
            //함수 진행
            System.out.println(1);
            long data = Math.abs(getResult(arr));
            answer = Math.max(answer, data);
            return;
        }
        String[] d = new String[]{"*","+","-"};
        for (int i = 0; i < d.length; i++) {
            if (!arr.contains(d[i])){
                arr.add(d[i]);
                makeFlow(arr);
                arr.remove(d[i]);
            }
        }
    }
    //100-200*300-500+20
    public static long getResult(ArrayList<String> flow){
        Deque<String> deque = new LinkedList<>();
        int left = 0;
        for (int i = 0; i < ex.length(); i++) {
            if (ex.charAt(i) == '+' || ex.charAt(i) == '-' || ex.charAt(i) == '*') {
                String data = ex.substring(left, i);
                deque.add(data);
                deque.add(String.valueOf(ex.charAt(i)));
                left = i + 1;
            }
        }
        deque.add(ex.substring(left, ex.length()));
        for (String opt: flow){
            Stack<String> save = new Stack<>();
            while(!deque.isEmpty()){
                String temp = deque.pollFirst();
                if(temp.equals(opt)){
                    String rv = deque.pollFirst();
                    String lv = save.pop();
                    deque.addFirst(calc(opt, lv, rv));
                }else{
                    save.push(temp);
                }
            }
            while(!save.isEmpty()){
                deque.push(save.pop());
            }
        }
        String ans = deque.pop();
        return Long.parseLong(ans);
    }
    public static String calc(String opt, String left, String right){
        long leftValue = 0;
        if(left.charAt(0)=='-')
            leftValue = Long.parseLong(left.substring(1, left.length()))*-1;
        else
            leftValue = Long.parseLong(left.substring(0, left.length()));
        long data = 0;
        if(opt.equals("+")){
            data = leftValue+ Long.parseLong(right);
        }else if(opt.equals("-")){
            data = leftValue - Long.parseLong(right);
        }else{
            data = leftValue * Long.parseLong(right);
        }
        return String.valueOf(data);
    }
}
