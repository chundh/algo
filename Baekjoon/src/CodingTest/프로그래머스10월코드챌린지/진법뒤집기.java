package CodingTest.���α׷��ӽ�10���ڵ�ç����;

import java.util.Scanner;

public class ���������� {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String a = toDeposition(n, 3);
        String b = "";
        for(int i=a.length()-1; i>=0; i--){
            b += a.substring(i, i+1);
        }
        int ans = 0;
        int pivot = (int) Math.pow(3,b.length()-1);
        for(int i=0; i<b.length(); i++){
            ans += Integer.parseInt(b.substring(i, i+1)) * pivot;
            pivot/=3;
        }
        System.out.println(ans);
    }
    public static String toDeposition(int value, int i){

        String returnString = "";
        String temp = "";


        while(value != 0){

            // �������� 0~9 �����̸�  ĳ���� ���� �迭�� ����
            if( (value % i) < 10 ) {
                //���ڿ� ��->�·� �迭
                returnString = (value % i) + returnString;
                //���� ����
                value /= i;
            }
            // �������� 10 �̻��̸� �ش��ϴ� ���� ���ĺ��� ����
            else {
                int temp1 = (char)((value % i)  + 55);

                returnString = Integer.toString(temp1) + returnString;
            }

        }

        return returnString;

    }
}
