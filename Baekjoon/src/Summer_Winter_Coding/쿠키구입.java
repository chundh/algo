package Summer_Winter_Coding;

/**
 * 타겟을 이동하면서 투포인터 개념을 사용한 문제.
 */

public class 쿠키구입 {
    public static void main(String[] args) {
        int[] cookie = {1,1,2,3,3,5,8,5,2,1};
        solution(cookie);
    }
    public static int solution(int[] cookie){
        int answer = 0;
        for (int target=0; target<cookie.length-1; target++){
            int left = target;
            int right = target+1;
            int sumL = cookie[left];
            int sumR = cookie[right];
            while (true){
                if(sumL<sumR){
                    left--;
                    if(left<0)
                        break;
                    sumL += cookie[left];
                }else if(sumL>sumR){
                    right++;
                    if(right>=cookie.length)
                        break;
                    sumR += cookie[right];
                }else {
                    answer = Math.max(answer, sumL);
                    left--;
                    right++;
                    if (left<0 || right>=cookie.length)
                        break;
                    sumL += cookie[left];
                    sumR += cookie[right];
                }
            }
        }
        System.out.println(answer);
        return answer;
    }
}
