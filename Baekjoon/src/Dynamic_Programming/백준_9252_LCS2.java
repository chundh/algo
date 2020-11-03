package Dynamic_Programming;

import java.util.Scanner;

/**
 * ���� ���� ������ (Longest Common Sequence)
 * �� ���ڿ��� ����Ǵ� �κ� ���� ������ ���ϴ� �Լ�.(���ӵ� ���ڿ��� �ƴϿ��� �ȴ�.)
 * ������ ���ϰ�, ������ Ž���ϸ鼭 ���ڿ��� �˾Ƴ� �� �ִ�.
 */

public class ����_9252_LCS2 {
    static String a;
    static String b;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextLine();
        b = sc.nextLine();
        int[][] data = new int[a.length()+1][b.length()+1];
        for (int i = 1; i <= a.length(); i++) {
            for(int j=1; j <= b.length(); j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    data[i][j] = data[i-1][j-1]+1;
                }else{
                    data[i][j] = Math.max(data[i-1][j], data[i][j-1]);
                }
            }
        }
        int x = a.length();
        int y = b.length();
        String answer="";
        while(true){
            if(data[x][y]==0)
                break;
            if(a.charAt(x-1)==b.charAt(y-1)){
                answer = b.charAt(y-1) + answer;
                x--;
                y--;
            }else{
                if(data[x][y] == data[x-1][y]){
                    x--;
                }else{
                    y--;
                }
            }
        }
        System.out.println(data[a.length()][b.length()]);
        System.out.println(answer);
    }
}
/*
aca
cac
 */