package CodingTest.프로그래머스10월코드챌린지;
//나를 기준으로 가장 먼 노드 까지의 길이*2/3
//https://lotuslee.tistory.com/12
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class 트리트리오중간값 {
    static int[] visit;
    static Vector<node>[] vector;
    static class node{
        int num;
        int weight;

        public node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1,5}, {2,5}, {3,5}, {4,5}};
        solution(n, edges);
    }
    public static void solution(int n, int[][] edges){
        vector = new Vector[n+1];
        for(int i=1; i<=n; i++){
            vector[i] = new Vector<>();
        }
        for(int i=0; i<edges.length; i++){
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            vector[v1].add(new node(v2, 1));
            vector[v2].add(new node(v1, 1));
        }
        visit = new int[n+1];
        int first_num = 1;
        node firstNode = getTreeDiameter(first_num);
        System.out.println(firstNode.num + " , " + firstNode.weight);
        visit = new int[n+1];
        node secondNode = getTreeDiameter(firstNode.num);
        int len = secondNode.weight;
        int cnt = 0;
        for(int i=1; i<=n; i++){
            if(visit[i] == len){
                cnt++;
            }
            if(cnt>=2) {
                System.out.println(len);
                return;
            }
        }
        visit = new int[n+1];
        firstNode = secondNode;
        secondNode = getTreeDiameter(secondNode.num);
        len = secondNode.weight;
        cnt = 0;
        for(int i=1; i<=n; i++){
            if(visit[i] == len){
                cnt++;
            }
            if(cnt>=2) {
                System.out.println(len);
                return;
            }
        }
        System.out.println(secondNode.weight-1);
        return;

    }
    static node getTreeDiameter(int s){
        int max = 0;
        int n = 0;
        Queue<node> queue =new LinkedList<>();
        queue.add(new node(s, 0));
        visit[s] = 0;
        while(!queue.isEmpty()){
            node temp = queue.poll();
            for(node next : vector[temp.num]){
                if(visit[next.num] == 0 && next.num!=s) {
                    visit[next.num] = visit[temp.num] + 1;
                    if(max<visit[next.num]){
                        max = visit[next.num];
                        n = next.num;
                    }
                    queue.add(new node(next.num, visit[next.num]));
                }
            }
        }
        return new node(n, max);
    }
}
/*
int n = 4;
int[][] edges = {{1,2},{2,3},{3,4}};

int n = 5;
int[][] edges = {{1,5}, {2,5}, {3,5}, {4,5}};
 */