package Graph;

import java.util.ArrayList;

public class FarNode {
    static ArrayList<ArrayList<Integer>> ad;
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(solution(n, edge));
    }

    public static int solution(int n, int[][] edge){
        int nV = n+1;
        int nE = edge.length;
        ad = new <ArrayList<Integer>> ArrayList(); // 인접 리스트 초기화
        for(int i = 0; i < nV; i++){
            ad.add(new<Integer> ArrayList());  //ad 리스트에 담을 리스트 초기화
        }

        for(int i = 0; i < nE; i++){
            int t1, t2;         // vertex 두 개 입력 받기
            t1 = edge[i][0];
            t2 = edge[i][1];
            ad.get(t1).add(t2);   // 양방향 그래프이므로, vertex 1, 2 값 초기화
            ad.get(t2).add(t1);
        }

        for(int i=0; i<nV; i++){
            for(int j=0; j<ad.get(i).size(); j++){
                System.out.print(ad.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println("-------------");
        int[] arr = new int[n+1];
        arr[1] = -1;
        makeLength(arr, 1, 1);
        /*  다익스트라 알고리즘.
        class Node implements Comparable<Node> {
            int index;
            int dist;
            public Node(int index, int dist) {
                this.index = index;
                this.dist = dist;
            }
            @Override
            public int compareTo(Node o) {
                return Integer.compare(dist, o.dist);
            }
        }
            List<List<Integer>> adj_lists = new ArrayList<>();
            PriorityQueue<Node> heap = new PriorityQueue<>(); // node를 거리순으로 오름차순 정렬하게끔 구성.
            dists[1] = 0;
            heap.add(new Node(1, dists[1]));
            while (!heap.isEmpty()) {
            Node node = heap.remove();
            for (int indVisit: adj_lists.get(node.index)) {
                if (node.dist + 1 < dists[indVisit]) {
                    dists[indVisit] = node.dist + 1;
                    heap.add(new Node(indVisit, dists[indVisit]));
                }
            }

        밑에 재귀 함수보다 훨씬 효율적으로 데이터 구성이 가능하다.
         */
        int answer = 0;
        int max = 0;
        for(int i=1; i<n+1; i++){
            if(max<arr[i]){
                max = arr[i];
                answer = 1;
            }
            else if(max == arr[i])
                answer ++;
        }
        return answer;
    }
    public static void makeLength(int[] arr, int node, int cnt){
        for(int i=0; i<ad.get(node).size(); i++){
            int num = ad.get(node).get(i);
            if(arr[num] != 0){
                if(arr[num]>cnt) {
                    arr[num] = cnt;
                    cnt++;
                    makeLength(arr, num, cnt);
                    cnt--;
                }
            }
            else{
                arr[num] = cnt;
                cnt++;
                makeLength(arr, num, cnt);
                cnt--;
            }
        }
    }
}