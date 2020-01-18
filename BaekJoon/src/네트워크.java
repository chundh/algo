import java.util.ArrayList;
import java.util.LinkedList;

public class 네트워크 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[][] computers = {{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 0}, {1, 0, 0, 1}};
		solution(n, computers);
	}
	public static void solution(int n, int[][] computers) {
		ArrayList<LinkedList> arr = new ArrayList<LinkedList>();
		int flag=0;
		int count=0;
		for(int i=0; i<computers.length; i++) {
			for(int j=i+1; j<computers.length; j++) {
				if(computers[i][j]==1) { //i와 j가 연결되어있는 경우
					for(int k=0; k<arr.size(); k++) {
						if(arr.get(k).contains(i)) {
							System.out.println(k+"번째 리스트에 " + i + "존재");
							arr.get(k).add(j);
							flag=1;
							count++;
						}
						else if(arr.get(k).contains(j)) {
							System.out.println(k+"번째 리스트에 " + j + "존재");
							arr.get(k).add(i);
							flag=1;
							count++;
						}
					}
					if(flag==0) {
						System.out.println("현재 노드중에"+ i + " , " + j + "가 추가되어있는 노드가 없음.");
						LinkedList<Integer> lt = new LinkedList<Integer>();
						lt.add(i);
						lt.add(j);
						arr.add(lt);
						count+=2;
					}
					flag=0;
				}
			}
		}
		System.out.println(n + 1 - count);
	}

}

/* dfs로 푼 정답코드
 class Solution {
    static boolean[][] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i][i]) {
                dfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    static void dfs(int start, int n, int[][] computers) {
        for (int i = 0; i < n; i++) {
            if (computers[start][i] == 1 && !visited[start][i]) {
                visited[start][i ] =visited[i][start] = true;
                dfs(i, n, computers);
            }
        }
    }
}
 */
