package CodingTest.프로그래머스11월코드챌린지;

public class programming1 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};
        solution(a,b);
    }
    public static void solution(int[] a, int[] b){
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            int data = a[i] * b[i];
            answer += data;
        }
        System.out.println(answer);
    }
}
