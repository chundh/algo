package �˰�����.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * �ּ� ����Ʈ���� ���ϴ� �˰����̴�.
 * ���� ���� ���� ����Ŭ ���� �׷����� �ϼ���Ų��.
 * �켱���� ť�� ����� ���� �� �� �ִ� ���� �� ����ġ�� ���� ���� ���� ���Ѵ�.
 * �ѹ� �湮�� ����� �Ÿ��� 0���� �ٲ��ְ� �ߺ��� ����Ŭ�� ����� ���� ���´�.
 * ��� ������ Ž���ϸ鼭 �ּ� ���� Ʈ���� �ϼ��Ѵ�.
 */

public class ���� {
    static class node implements Comparable<node>{
        int num;
        int weight;
        public node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
        @Override
        public int compareTo(node o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) {
        String[] data = {"5 1 1",
                "1 2 2",
                "1 3 3",
                "2 3 4",
                "2 4 5",
                "3 4 6"};
        int v = 5;
        int e = data.length;
        ArrayList<ArrayList<node>> arr = new ArrayList<>();
        for(int i=0; i<=v; i++){
            arr.add(new ArrayList<>());
        }
        for(int i=0; i<e; i++){
            String[] temp = data[i].split(" ");
            int v1 = Integer.parseInt(temp[0]);
            int v2 = Integer.parseInt(temp[1]);
            int w = Integer.parseInt(temp[2]);
            arr.get(v1).add(new node(v2, w));
            arr.get(v2).add(new node(v1, w));
        }
        // i��° ��尡 ���� ����Ǵ� ������ ���� ����
        int[] from = new int[v+1];
        // Ž���� �� ���� ����ġ�� ���� ������ ã�� �� Ȱ��
        int[] dist = new int[v+1];
        for(int i=1; i<=v; i++){
            dist[i] = Integer.MAX_VALUE;
            from[i] = 0;
        }
        from[1] = 1;
        dist[1] = 0;
        PriorityQueue<node> queue = new PriorityQueue<>();
        queue.add(new node(1,0));
        while(!queue.isEmpty()){
            node temp = queue.poll();
            // temp�� weight�� dist�� ���� �ٸ��ٸ� �ִܰŸ� ���� ���� �������̹Ƿ� continue�Ѵ�.
            if(temp.weight != dist[temp.num])
                continue;
            dist[temp.num] = 0;
            for(node next : arr.get(temp.num)){
                if(dist[next.num] > next.weight){
                    dist[next.num] = next.weight;
                    from[next.num] = temp.num;
                    queue.add(new node(next.num, dist[next.num]));
                }
            }
        }
        System.out.println(Arrays.toString(from));
        System.out.println(Arrays.toString(dist));
    }
}
