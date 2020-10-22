package 알고리즘구현.Graph;

/**
 * 모든 정점에서 모든 정점까지의 최단 거리를 구하는 알고리즘이다.
 */

public class 플로이드 {
    public static void main(String[] args) {
        int n = 5;
        String[] data = {"5 1 1",
                "1 2 2",
                "1 3 3",
                "2 3 4",
                "2 4 5",
                "3 4 6"};
        int[][] map = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                map[i][j] = 1000000;
            }
        }
        for(int i=0; i<data.length; i++){
            String[] temp = data[i].split(" ");
            int v1 = Integer.parseInt(temp[0]);
            int v2 = Integer.parseInt(temp[1]);
            int w = Integer.parseInt(temp[2]);
            map[v1][v2] = w;
            map[v2][v1] = w;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    if(i==j)
                        continue;
                    if(map[i][j] > map[i][k] + map[j][k]){
                        map[i][j] = map[i][k] + map[j][k];
                    }
                }
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
}
