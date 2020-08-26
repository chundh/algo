package Dynamic_Programming;

/**
 * 프로그래머스 도둑질 문제
 * 0번인덱스부터 최대값이 되는 조건을 찾으며 배열 진행
 * dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i])
 */

public class Programmers_Steel {
    public static void main(String[] args) {
        int[] money = {1,2,3,1};
        solution(money);
    }

    public static void solution(int[] money){
        int answer = 0;
        int[] arr = new int[money.length];
        arr[0] = money[0];
        arr[1] = money[1];
        arr[2] = Math.max(arr[0]+money[2], arr[1]);
        for(int i=3; i< money.length; i++){
            if(i== money.length-1){
                //arr[i] = Math.max(arr[i-2]+money[i]-arr[0], arr[i-1]);
            }
            arr[i] = Math.max(Math.max(arr[i-1], arr[i-2]+money[i]), arr[i-3]+money[i]);
        }
        answer = arr[money.length-1];
        System.out.println(answer);
    }
}
