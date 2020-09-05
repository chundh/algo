package Graph;

import java.util.ArrayList;

/**
 * 1. 자신의 자식 + 부모의 크기가 n-1이면 등수 확정. (n-win_number)
 * 2. 자신의 위 or 아래 등수를 안다면
 */

public class 순위 {
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        solution(n, results);
    }
    public static int solution(int n, int[][] results){
        int answer = 0;
        member[] arr = new member[n+1];
        for(int i=1; i<n+1; i++){
            arr[i] = new member();
        }
        for(int i=0; i<results.length; i++){
            arr[results[i][0]].child.add(results[i][1]);
            arr[results[i][1]].parent.add(results[i][0]);
        }
        for(int i=1; i<n+1; i++){
            if(arr[i].parent.size()!=0){
                for(int j=0; j<arr[i].parent.size(); j++) {
                    for(int k=0; k<arr[i].child.size(); k++) {
                        if(!arr[arr[i].child.get(k)].parent.contains(arr[i].parent.get(j)))
                            arr[arr[i].child.get(k)].parent.add(arr[i].parent.get(j));
                        if(!arr[arr[i].parent.get(j)].child.contains(arr[i].child.get(k)))
                            arr[arr[i].parent.get(j)].child.add(arr[i].child.get(k));
                    }
                }
            }
        }
        for(int i=1; i<n+1; i++){
            if(arr[i].parent.size() + arr[i].child.size() == n-1)
                answer++;
            //System.out.println(arr[i].child.size()+ " , " + arr[i].parent.size());
        }

        return answer;
    }
}
class member{
    ArrayList<Integer> child;
    ArrayList<Integer> parent;
    public member(){
        child = new ArrayList<>();
        parent = new ArrayList<>();
    }
}