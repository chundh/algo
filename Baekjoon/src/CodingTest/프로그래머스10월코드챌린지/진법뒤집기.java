package CodingTest.프로그래머스10월코드챌린지;

import java.util.Scanner;

public class 진법뒤집기 {
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

            // 나머지가 0~9 사이이면  캐릭터 값을 배열에 저장
            if( (value % i) < 10 ) {
                //문자열 우->좌로 배열
                returnString = (value % i) + returnString;
                //몫을 구함
                value /= i;
            }
            // 나머지가 10 이상이면 해당하는 값의 알파벳을 저장
            else {
                int temp1 = (char)((value % i)  + 55);

                returnString = Integer.toString(temp1) + returnString;
            }

        }

        return returnString;

    }
}
