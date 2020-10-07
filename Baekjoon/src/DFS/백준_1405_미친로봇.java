package DFS;

import java.util.Scanner;

// 단순한 경우의 확률을 모두 더하기
// 중간에 단순하지 않은 경우가 나오면 return;

public class 백준_1405_미친로봇 {
    static double[] percent = new double[4];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<4; i++){
            percent[i] = sc.nextDouble();
        }
        boolean[][] check = new boolean[30][30];
        //14,14부터 시작
        System.out.println(dfs(14, 14, n, check, 1));

    }
    static double dfs(int x, int y, int n, boolean[][] check, double per){
        if(check[x][y])
            return 0;
        if(n==0){
            return per;
        }
        check[x][y] = true;
        double num1 = 0;
        double num2 = 0;
        double num3 = 0;
        double num4 = 0;
        if(percent[0] != 0) {
            num1 = 1;
            num1 *= dfs(x, y + 1, n - 1, check, per * percent[0] / 100);
        }
        if(percent[1] != 0) {
            num2 = 1;
            num2 *= dfs(x, y - 1, n - 1, check, per * percent[1] / 100);
        }
        if(percent[2] != 0) {
            num3 = 1;
            num3 *= dfs(x + 1, y, n - 1, check, per * percent[2] / 100);
        }
        if(percent[3] != 0) {
            num4 = 1;
            num4 *= dfs(x - 1, y, n - 1, check, per * percent[3] / 100);
        }
        check[x][y] = false;
        return num1+num2+num3+num4;
    }
}

