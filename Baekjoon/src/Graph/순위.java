package Graph;

import java.util.ArrayList;

public class ¼øÀ§ {
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
            System.out.println(arr[i].child.size() + " , " + arr[i].parent.size());
        }
        for(int i=1; i<n+1; i++){
            if(arr[i].child.size() + arr[i].parent.size()==n-1){
                answer++;
            }
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