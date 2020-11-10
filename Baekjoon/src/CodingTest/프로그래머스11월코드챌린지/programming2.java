package CodingTest.프로그래머스11월코드챌린지;

public class programming2 {
    public static void main(String[] args) {
        String s = "110010101001";
        solution(s);
    }
    public static void solution(String s){
        int idx = 0;
        String data = s;
        int answer = 0;
        while(true){
            if(data.equals("1"))
                break;
            int count = 0;
            for (int i = 0; i < data.length(); i++) {
                if (data.charAt(i)=='1'){
                    count++;
                }
            }
            answer += data.length()-count;
            data = Integer.toBinaryString(count);
            idx++;
        }
        System.out.println(idx+ ":"+ answer);
        int[] arr = new int[]{idx, answer};
    }
}
