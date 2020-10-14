package ���α׷��ӽ�9���ڵ�ç����;

import java.util.PriorityQueue;

public class �ΰ��̾Ƽ����ϱ� {
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        solution(numbers);
    }
    public static int[] solution(int[] numbers){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                int num = numbers[i] + numbers[j];
                if(!queue.contains(num)){
                    queue.add(num);
                }
            }
        }
        int[] answer = new int[queue.size()];
        for(int i=0; i<answer.length;i++){
            answer[i] = queue.poll();
            System.out.println(answer[i]);
        }
        return answer;
    }
}
