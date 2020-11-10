package CodingTest.카카오2020인턴십;

public class 키패드누르기 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(solution(numbers, hand));
    }
    public static String solution(int[] numbers, String hand){
        int[] left = {4,1};
        int[] right = {4,3};
        String answer = "";

        for (int i = 0; i < numbers.length; i++) {
            int temp = numbers[i];
            if(temp==1 || temp==4 || temp==7){
                answer+="L";
                left[0] = 1+temp/3;
                left[1] = 1;
            }else if(temp==2 || temp==5 || temp==8 || temp==0){
                if(temp==0)
                    temp=11;
                int y=2;
                int x = (temp-1)%3 + temp/3;
                int left_len = Math.abs(left[0] - x) + Math.abs(left[1]-y);
                int right_len = Math.abs(right[0] - x) + Math.abs(right[1]-y);
                if(left_len<right_len){
                    left[0] = x;
                    left[1] = y;
                    answer+="L";
                }else if(left_len>right_len){
                    right[0] = x;
                    right[1] = y;
                    answer+="R";
                }else{
                    System.out.println(temp);
                    if(hand.equals("right")){
                        right[0] = x;
                        right[1] = y;
                        answer+="R";
                    }else {
                        left[0] = x;
                        left[1] = y;
                        answer += "L";
                    }
                }
            }else if(temp==3 || temp==6 || temp==9){
                right[0] = temp/3;
                right[1] = 3;
                answer+="R";
            }
        }
        return answer;
    }
}
