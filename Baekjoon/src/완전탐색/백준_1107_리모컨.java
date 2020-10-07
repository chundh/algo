package 완전탐색;

import java.io.*;
import java.util.StringTokenizer;

public class 백준_1107_리모컨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        int cnt = Integer.parseInt(br.readLine());
        int[] arr = new int[10];
        if(cnt!=0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < cnt; i++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[temp] = 1;
            }
        }
        if(cnt==10) {
            System.out.println(Math.abs(Integer.parseInt(data)-100));
            return;
        }
        int answer = 500001;
        int int_Data = Integer.parseInt(data);
        int init = Math.abs(int_Data-100);
        for(int i=0; i<=999999; i++){
            if(check(arr, i)){
                int temp = Math.abs(int_Data-i) + String.valueOf(i).length();
                answer = Math.min(answer, Math.min(temp, init));
            }
        }
        System.out.println(answer);
    }
    public static boolean check(int[] arr, int num){
        int len = String.valueOf(num).length()-1;
        for(int i=len; i>=0; i--){
            int pivot = (int) Math.pow(10,i);
            int m = num/pivot;
            if(arr[m] == 1){
                return false;
            }
            num = num%pivot;
        }
        return true;
    }
}
