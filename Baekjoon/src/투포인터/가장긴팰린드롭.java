package 투포인터;

public class 가장긴팰린드롭 {
    public static void main(String[] args) {
        String s = "abba";
        solution(s);
    }
    public static int solution(String s){
        int pivot = 0;
        int left = 0;
        int right=0;
        int answer = 1;
        if(s.length()==1){
            return 1;
        }else if(s.length()==0)
            return 0;
        for(int i=0; i<s.length(); i++){
            pivot = i;
            left = pivot;
            right = pivot;
            if(pivot!=s.length()-1){
                int cnt = 0;
                if(s.charAt(pivot) == s.charAt(pivot+1)){
                    right = pivot+1;
                    for(int j=1; ;){
                        left -= j;
                        right += j;
                        if(left<0 || right>=s.length()){
                            break;
                        }
                        if(s.charAt(left)==s.charAt(right)){
                            cnt++;
                        }else{
                            break;
                        }
                    }
                    int temp = 2 + cnt*2;
                    answer = Math.max(answer, temp);
                }
            }
            left = pivot;
            right = pivot;
            int cnt = 0;
            for(int j=1; ;){
                left -= j;
                right += j;
                if(left<0 || right>=s.length()){
                    break;
                }
                if(s.charAt(left)==s.charAt(right)){
                    cnt++;
                }else{
                    break;
                }
            }
            int temp = 1 + cnt*2;
            answer = Math.max(answer, temp);
        }
        System.out.println(answer);
        return answer;
    }
}
