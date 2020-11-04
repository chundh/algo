package Summer_Winter_Coding;

/**
 * 단순 구현문제
 */

public class 기지국설치 {
    public static void main(String[] args) {
//        int n = 11;
//        int[] stations = {4, 11};
//        int w = 1;
        int n = 16;
        int[] stations = {9};
        int w = 2;
        solution(n, stations, w);
    }
    public static int solution(int n, int[] stations, int w){
        int answer = 0;
        int data = stations[0]-w-1;
        int mod = 1+(2*w);
        answer += check(data, mod);
        for(int i=0; i<stations.length-1; i++){
            data = (stations[i+1]-w) - (stations[i]+w+1);
            answer += check(data, mod);
        }
        answer += check(n-(stations[stations.length-1]+w),mod);
        System.out.println(answer);
        return answer;
    }
    public static int check(int data, int mod){
        if(data<0)
            return 0;
        int cnt = 0;
        cnt += data/mod;
        if(data%mod!=0)
            cnt++;
        return cnt;
    }
}
