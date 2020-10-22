package �˰�����.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ���ͽ�Ʈ�� {
    static class node implements Comparable<node>{
        int num;
        int weight;
        public node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
        @Override
        public int compareTo(node o) {
            return this.weight-o.weight;
        }
    }

    public static void main(String[] args) {
        // u->v ����ġ w, 1����忡�� ����
        // ������ ��=5
        int num = 5;
        String[] data = {"5 1 1",
                "1 2 2",
                "1 3 3",
                "2 3 4",
                "2 4 5",
                "3 4 6"};
        // list�� ���� ������ ǥ���Ѵ�.
        ArrayList<ArrayList<node>> arr= new ArrayList<>();
        for(int i=0; i<=num; i++){
            arr.add(new ArrayList<>());
        }
        // list.get(u)�� v�� w�� �߰��ϸ� ������踦 �����.
        for(int i=0; i<data.length; i++){
            String[] temp = data[i].split(" ");
            int u = Integer.parseInt(temp[0]);
            int v = Integer.parseInt(temp[1]);
            int w = Integer.parseInt(temp[2]);
            arr.get(u).add(new node(v,w));
        }
        // �켱���� ť�� ����ϸ� 1������ Ž���� �����Ѵ�.
        // �켱���� ť�� ���� ���� �� �� �ִ� ��� �� ����ġ�� ���� ���� ��带 ���� Ž���Ѵ�.
        PriorityQueue<node> queue = new PriorityQueue<>();
        queue.add(new node(1,0));
        // ��ü �Ÿ��� ū ���� �ʱ�ȭ ���ش�.
        int[] len = new int[data.length];
        for (int i = 0; i < len.length; i++) {
            len[i] = Integer.MAX_VALUE;
        }
        len[1] = 0;
        while(!queue.isEmpty()){
            node temp = queue.poll();
            // len�� �ִ� �ִܰŸ��� ������ ����ġ�� �ٸ� ���
            // �ٸ� ��θ� ���� �ִܰŸ��� ������Ʈ �Ǿ����Ƿ� ���� ���� ��δ�.
            if(temp.weight != len[temp.num])
                continue;
            for(node next : arr.get(temp.num)){
                // ������� temp�� �����ϴ� �Ÿ����� ���ŵ� �Ÿ��� �� ª�� ���
                if(len[temp.num] + next.weight < len[next.num]){
                    // �ִ� ��θ� �����ϰ� next��带 Ž�� ��� �߰��Ѵ�.
                    len[next.num] = len[temp.num] + next.weight;
                    queue.add(new node(next.num , len[next.num]));
                }
            }
        }
        System.out.println(Arrays.toString(len));
    }
}
