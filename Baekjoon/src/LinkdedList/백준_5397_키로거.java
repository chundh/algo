package LinkdedList;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class 백준_5397_키로거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<t; tc++){
            Stack<Character> lstack = new Stack<>();
            Stack<Character> rstack = new Stack<>();
            String data = br.readLine();
            for(int i=0; i<data.length(); i++){
                char temp = data.charAt(i);
                if(temp == '<'){
                    if(!lstack.isEmpty()){
                        rstack.add(lstack.pop());
                    }
                }else if(temp == '>'){
                    if(!rstack.isEmpty()){
                        lstack.add(rstack.pop());
                    }
                }else if(temp == '-'){
                    if(!lstack.isEmpty()){
                        lstack.pop();
                    }
                }else{
                    lstack.add(temp);
                }
            }
            while(!lstack.isEmpty()){
                rstack.add(lstack.pop());
            }
            while(!rstack.isEmpty()){
                bw.write(rstack.pop());
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();


//        for(int tc = 0; tc<t; tc++){
//            String data = br.readLine();
//            LinkedList<Character> arr = new LinkedList<>();
//            int cursor = 0;
//            for(int i=0; i<data.length(); i++){
//                char temp = data.charAt(i);
//                if(temp == '<'){
//                    if(cursor>0){
//                        cursor--;
//                    }
//                }else if(temp == '>'){
//                    if(cursor<arr.size()){
//                        cursor++;
//                    }
//                }else if(temp == '-'){
//                    if(cursor>0){
//                        cursor--;
//                        arr.remove(cursor);
//                    }
//                }else{
//                    arr.add(cursor, temp);
//                    cursor++;
//                }
//            }
//            for(int j=0; j<arr.size(); j++){
//                bw.write(arr.get(j));
//            }
//            bw.newLine();
//        }
//        bw.flush();
//        bw.close();
    }
}
