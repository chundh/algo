package ¿ÏÀüÅ½»ö;

import java.util.Scanner;

public class ¹éÁØ_20164_È¦¼öÈ¦¸¯È£¼® {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n, 0);
        System.out.println(min + " " + max);
    }
    public static void solution(int n, int cnt){
        cnt += getOdd(n);
        if(n<10){
            max = Math.max(max, cnt);
            min = Math.min(min, cnt);
        }else if(n<100){
            int a = n/10;
            int b = n%10;
            solution(a+b, cnt);
        }else{
            String data = String.valueOf(n);
            for (int i = 1; i < data.length()-1; i++) {
                for (int j = i+1; j < data.length(); j++) {
                    int temp = split(data, i, j);
                    solution(temp, cnt);
                }
            }
        }
    }
    public static int split(String data, int idx1, int idx2){
        int a = Integer.parseInt(data.substring(0, idx1));
        int b = Integer.parseInt(data.substring(idx1, idx2));
        int c = Integer.parseInt(data.substring(idx2, data.length()));
        int sum = a + b + c;

        return sum;
    }

    public static int getOdd(int n){
        String temp = String.valueOf(n);
        int cnt = 0;
        for (int i = 0; i < temp.length(); i++) {
            if(Integer.parseInt(temp.substring(i, i+1))%2 == 1)
                cnt++;
        }
        return cnt;
    }
}
