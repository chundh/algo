package Summer_Winter_Coding;

import java.util.Arrays;
import java.util.HashMap;

public class 영어끝말잇기 {
    public static void main(String[] args) {
        int n= 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println(Arrays.toString(solution(n, words)));
    }
    public static int[] solution(int n, String[] words){
        HashMap<String, Integer> map = new HashMap<>();
        int[] answer = {0,0};
        int idx = 1;
        int cnt = 1;
        while(true){
           if(idx>words.length)
               break;
           if(map.containsKey(words[idx-1])){
               answer[0] = idx%n;
               if(idx%n==0)
                   answer[0] = n;
               answer[1] = cnt;
               break;
           }
           if(words[idx-1].length()==1){
               answer[0] = idx%n;
               if(idx%n==0)
                   answer[0] = n;
               answer[1] = cnt;
               break;
           }
           if(idx!=1){
               if (words[idx-2].charAt(words[idx-2].length()-1) != words[idx-1].charAt(0)){
                   answer[0] = idx%n;
                   if(idx%n==0)
                       answer[0] = n;
                   answer[1] = cnt;
                   break;
               }
           }
           if(idx%n==0)
               cnt++;
            map.put(words[idx-1], 1);
            idx++;
        }
        return answer;
    }
}
/*
"hello", "one", "even", "never", "now", "world", "draw"
"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"
 */