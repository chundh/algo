package Summer_Winter_Coding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 정렬하고 쓰는거도 문제에 따라 나쁘지 않다!
 */

public class 숫자게임 {
    public static void main(String[] args) {
        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};
//        int[] A = {2,2,2,2};
//        int[] B = {1,1,1,1};
        System.out.println(solution(A, B));
    }
    public static int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int aidx=0;
        int bidx=0;
        int ans=0;
        while(true){
            if(aidx>=A.length || bidx>=B.length){
                break;
            }
            if(A[aidx]>=B[bidx]){
                bidx++;
            }else{
                aidx++;
                bidx++;
                ans++;
            }
        }
        return ans;
    }
//    public static int solution(int[] A, int[] B){
//        int answer = 0;
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        for (int i = 0; i < B.length; i++) {
//            queue.add(B[i]);
//        }
//        for(int i=0; i<A.length; i++){
//            Queue<Integer> po = new LinkedList<>();
//            while(!queue.isEmpty()){
//                int temp = queue.poll();
//                if(temp<=A[i]){
//                    po.add(temp);
//                }else{
//                    answer++;
//                    break;
//                }
//            }
//            while(!po.isEmpty())
//                queue.add(po.poll());
//        }
//        return answer;
//    }
}
