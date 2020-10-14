package 프로그래머스9월코드챌린지;

public class 풍선터트리기 {
    public static void main(String[] args) {
        int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
        solution(a);
    }
    public static int solution(int[] a){
        int[] left_arr = new int[a.length];
        int[] right_arr = new int[a.length];
        left_arr[0] = a[0];
        right_arr[right_arr.length-1] = a[a.length-1];
        for(int i=1; i<a.length; i++){
            left_arr[i] = Math.min(left_arr[i-1], a[i]);
            right_arr[right_arr.length-1-i] = Math.min(right_arr[right_arr.length-i], a[right_arr.length-1-i]);
        }
        int answer = 2;
        for(int i=1; i<a.length-1; i++){
            int num1 = left_arr[i-1];
            int num2 = right_arr[i+1];
            System.out.println(num1 + " , " + a[i] + " , " + num2);
            if(a[i]>num1 && a[i]>num2){
                continue;
            }
            answer++;
        }
        System.out.println(answer);
        return answer;
    }
}
