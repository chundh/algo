package Summer_Winter_Coding;

public class 점프와순간이동 {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(solution(n));
    }
    public static int solution(int n){
        int answer = 0;
        int idx = 1;
        while(true){
            if(n==0)
                break;
            if(n%2==0){
                n/=2;
            }else{
                answer++;
                n--;
            }
        }
        return answer;
    }
}
