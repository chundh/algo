package stack.queue;

import java.util.ArrayList;
import java.util.Scanner;

public class 백준_1874_스택수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int idx = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=k; i++){
            int data = sc.nextInt();
            if(data>idx) {
                while (true) {
                    if (idx > data)
                        break;
                    arr.add(idx);
                    idx++;
                    sb.append("+" + "\n");
                }
                sb.append("-" + "\n");
                arr.remove(arr.size()-1);
            }else {
                while(true){
                    if(arr.size()==0){
                        sb = new StringBuilder();
                        sb.append("NO");
                        break;
                    }
                    int d = arr.get(arr.size()-1);
                    arr.remove(arr.size()-1);
                    sb.append("-" + "\n");
                    if(data==d){
                        break;
                    }else if(data>d){
                        sb = new StringBuilder();
                        sb.append("NO");
                        break;
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}
