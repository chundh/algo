package ���α׷��ӽ�10���ڵ�ç����;

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
    static boolean check(String s){ // true -> ���ڿ��� ���� ����
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=s.charAt(1)){
                return false;
            }
        }
        return true;
    }
}
