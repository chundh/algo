package 프로그래머스10월코드챌린지;

public class programming4 {
    static long answer = 0;
    public static void main(String[] args) {
        String s = "baby";
        solution(s);
    }
    public static void solution(String s){

    }
    public static void recur(String s){
        if(s.length()==1){
            return;
        }
        recur(s.substring(0, s.length()/2));
        recur(s.substring(s.length()/2, s.length()));
    }
    static boolean check(String s){ // true -> 문자열이 저누 같음
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=s.charAt(1)){
                return false;
            }
        }
        return true;
    }
}
