package Dynamic_Programming;

import java.util.Scanner;

/**
 * �ִ� ���� �κ� ���ڿ�
 * �ΰ��� String�� �κ� ���ڿ��� �ش��ϴ� �� �� �ִ����.
 *
 */

public class ����_5582_����κй��ڿ� {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int[][] data = new int[s1.length()+1][s2.length()+1];
        int answer = 0;
        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    data[i][j] = data[i-1][j-1]+1;
                    answer = Math.max(answer, data[i][j]);
                }else
                    data[i][j] = 0;
            }
        }
        System.out.println(answer);
    }
}
