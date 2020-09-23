package stack.queue;

import java.util.*;

public class 백준_2056_작업 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int[] time = new int[n+1];
        int[] answer = new int[n+1];
        int[] pos = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<=n; i++) {
            arr.add(new ArrayList<>());
            time[i] = 0;
            answer[i] = 0;
            pos[i] = 0;
        }
        for(int i=1; i<=n; i++){
            time[i] = sc.nextInt();
            int len = sc.nextInt();
            for(int j=0; j<len; j++){
                int t = sc.nextInt();
                arr.get(t).add(i);
                pos[i]++;
            }
        }
        for(int i=1; i<=n; i++){
            if(pos[i]==0){
                answer[i] = time[i];
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int next : arr.get(temp)){
                pos[next]--;
                answer[next] = Math.max(answer[next], answer[temp] + time[next]);
                if(pos[next]==0){
                    queue.offer(next);
                }
            }
        }
        int max = -1;
        for(int i=1; i<=n; i++){
            if(answer[i]>max)
                max = answer[i];
        }
        System.out.println(max);
    }
}
