package πÈ∆Æ∑°≈∑;

import java.io.*;
import java.util.StringTokenizer;

public class πÈ¡ÿ_1629_∞ˆº¿ {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        System.out.println(solution(a, b, c));
    }
    public static long solution(long a, long b, long c){
        if(b==0){
            return 1;
        }
        long temp = solution(a, b/2, c);
        temp%=c;
        temp = (temp*temp) % c;
        if(b%2==0){
            return temp;
        }else{
            return (temp * (a % c)) % c;
        }
    }
}
