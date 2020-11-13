package CodingTest.카카오코드2017예선;

import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static class point{
        int x;
        int y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        soluiton(m, n, picture);
    }
    public static void soluiton(int m, int n, int[][] picture){
        Queue<point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[picture.length][picture[0].length];
        int size = 0;
        int max = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                int cnt = 1;
                if(picture[i][j] != 0 && !visit[i][j]){
                    size++;
                    queue.add(new point(i, j));
                    visit[i][j] = true;
                    while(!queue.isEmpty()){
                        point temp = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = temp.x + dx[k];
                            int y = temp.y + dy[k];
                            if(x<0 || x>=picture.length || y<0 || y>=picture[0].length)
                                continue;
                            if(picture[x][y]==picture[i][j] && !visit[x][y]){
                                queue.add(new point(x,y));
                                cnt++;
                                visit[x][y] = true;
                            }
                        }
                    }
                }
                max = Math.max(max, cnt);
            }
        }
        System.out.println(size +  " , " + max);
    }
}
