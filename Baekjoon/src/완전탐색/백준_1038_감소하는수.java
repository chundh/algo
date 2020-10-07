package ����Ž��;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ����_1038_�����ϴ¼� {
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
            // ť���� �׻� �����ϴ� ���� �־��ְ�, poll���� ���� �ڱ⺸�� ���ڸ� ���� ���� �����ϴ� ���� �ٽ� ť�� �־��ش�.
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
