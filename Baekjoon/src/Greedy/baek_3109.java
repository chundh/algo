package Greedy;

import java.util.Scanner;

public class baek_3109 {
    static int r=0;
    static int c = 0;
    static int answer = 0;
    static int flag=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        String[][] arr = new String[r][c];
        for(int i=0; i<r; i++){
            String d = sc.next();
            String[] data = d.split("");
            for(int j=0; j<data.length; j++){
                arr[i][j] = data[j];
            }
        }
        boolean[][] check = new boolean[r][c];
        for(int i=0; i<r; i++){
            solution(arr, check, i, 0);
            flag=0;
        }
        System.out.println(answer);
    }

    public static void solution(String[][] arr, boolean[][] check, int i, int j){
        if(flag==1)
            return;
        if(i<0 || i>=r || j<0 || j>=c)
            return;
        if(arr[i][j].equals("x"))
            return;
        if(check[i][j])
            return;
        if(j==c-1){
            check[i][j] = true;
            answer++;
            flag=1;
            return;
        }
        check[i][j] = true;
        solution(arr, check, i-1, j+1);
        solution(arr, check, i, j+1);
        solution(arr, check, i+1, j+1);
    }
}
