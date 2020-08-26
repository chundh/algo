package Greedy;

import java.util.Scanner;

public class baek_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        while(true) {
            if(N%3==0 && N%5==0) {
                N-=5;
            }else if(N%5==0) {
                N-=5;
            }else if(N%3==0) {
                N-=3;
            }else {
                N-=5;
            }
            cnt++;

            if(N==0) {
                System.out.println(cnt);
                return;
            }
            if(N<0) {
                System.out.println(-1);
                return;
            }
        }
    }
}
