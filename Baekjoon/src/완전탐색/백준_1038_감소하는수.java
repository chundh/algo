package 완전탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_1038_감소하는수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[1000001];
        if(n>1022){
            System.out.println(-1);
        }else if(n<=10){
            System.out.println(n);
        }else{
            int cnt = 0;
            // 큐에는 항상 감소하는 수만 넣어주고, poll됬을 때는 자기보다 한자리 높은 수의 감소하는 수를 다시 큐에 넣어준다.
            Queue<Long> queue= new LinkedList<>();
            for(int i=1; i<10; i++){
                queue.add((long) i);
                cnt++;
            }
            while(true){
                long temp = queue.poll();
                long k = temp%10;
                for(int i=0; i<k; i++){
                    queue.add(temp*10 + i);
                    cnt++;
                    if(cnt==n){
                        System.out.println(temp*10 + i);
                        return;
                    }
                }
            }
        }
    }
}
