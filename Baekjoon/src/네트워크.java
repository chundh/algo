import java.util.ArrayList;
import java.util.LinkedList;
/*
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
				if(computers[i][j]==1) { //i占쏙옙 j占쏙옙 占쏙옙占쏙옙퓸占쏙옙獵占� 占쏙옙占�
					for(int k=0; k<arr.size(); k++) {
						if(arr.get(k).contains(i)) {
							System.out.println(k+"占쏙옙째 占쏙옙占쏙옙트占쏙옙 " + i + "占쏙옙占쏙옙");
							arr.get(k).add(j);
							flag=1;
							count++;
						}
						else if(arr.get(k).contains(j)) {
							System.out.println(k+"占쏙옙째 占쏙옙占쏙옙트占쏙옙 " + j + "占쏙옙占쏙옙");
							arr.get(k).add(i);
							flag=1;
							count++;
						}
					}
					if(flag==0) {
						System.out.println("占쏙옙占쏙옙 占쏙옙占쏙옙傷占�"+ i + " , " + j + "占쏙옙 占쌩곤옙占실억옙占쌍댐옙 占쏙옙弱� 占쏙옙占쏙옙.");
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

/* dfs占쏙옙 푼 占쏙옙占쏙옙占쌘듸옙
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
