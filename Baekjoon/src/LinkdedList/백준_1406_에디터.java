package LinkdedList;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * linkedlist로 풀면 시간초과가 나와서 stack으로 푼 문제
 * bufferedWriter 사용을 생활화 하자!!!
 */

public class 백준_1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String data = st.nextToken();
        st = new StringTokenizer(br.readLine());
        Stack<Character> lstack = new Stack<>();
        Stack<Character> rstack = new Stack<>();

        for(int i=0; i<data.length(); i++){
            lstack.add(data.charAt(i));
        }
        int n = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String opt = st.nextToken();
            if(opt.equals("P")){
                lstack.add(st.nextToken().charAt(0));
            }else if(opt.equals("L")){
                if(!lstack.isEmpty()){
                    rstack.add(lstack.pop());
                }
            }else if(opt.equals("D")){
                if(!rstack.isEmpty()){
                    lstack.add(rstack.pop());
                }
            }else{ // B
                if(!lstack.isEmpty()){
                    lstack.pop();
                }
            }
        }
        while(!lstack.isEmpty()){
            rstack.add(lstack.pop());
        }
        while(!rstack.isEmpty()){
            bw.write(rstack.pop());
        }
        bw.flush();
        bw.close();
    }
}
