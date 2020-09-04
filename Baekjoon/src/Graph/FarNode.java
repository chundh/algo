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