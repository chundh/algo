package 백트래킹;

import java.util.Scanner;

public class 백준_1074_Z {
    static int idx = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int len = (int) Math.pow(2, n);
        System.out.println(recur(r,c, len));
    }

    public static int recur(int x, int y, int n){
        if(n==0){
            return 0;
        }
        int d = n/2;
        if(x<d && y<d){
            return recur(x, y, n/2);
        }else if(x<d && y>=d){
            return d*d + recur(x, y-d, n/2);
        }else if(x>=d && y<d){
            return 2*d*d + recur(x-d, y, n/2);
        }else{
            return 3*d*d + recur(x-d, y-d, n/2);
        }
    }
}
