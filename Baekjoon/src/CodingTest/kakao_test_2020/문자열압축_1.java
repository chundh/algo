package CodingTest.kakao_test_2020;

public class 문자열압축_1 {
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        String s = "aa";

        solution(s);
    }
    public static void solution(String s){
        if(s.length()==1){
            answer = 1;
            return;
        }
        for(int i=1; i<s.length()/2+1; i++){
            String data = s.substring(0, i);
            String new_data = "";
            check(data, 0, i, 0, s, new_data);
        }
        System.out.println(answer);
    }
    public static void check(String data, int start, int term, int cnt, String s, String new_data){
        if(start+term>s.length()){ //마지막 부분
            if(cnt>=2){
                new_data += String.valueOf(cnt) + data + s.substring(start, s.length());
            }else {
                new_data += data + s.substring(start, s.length());
            }
            if(answer>new_data.length()){
                answer = new_data.length();
                System.out.println(new_data + " : " + term);
            }
            System.out.println(term + " : " + new_data);
            return;
        }
        if(data.equals(s.substring(start,start+term))){
            cnt++;
            check(data, start+term, term, cnt, s, new_data);
        }else{
            if(cnt>=2){
                new_data += String.valueOf(cnt) + data;
            }else{
                new_data += data;
            }
            String d = s.substring(start,start+term);
            check(d, start+term, term, 1, s, new_data);
        }
    }

}
