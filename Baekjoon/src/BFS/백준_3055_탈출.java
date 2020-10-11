package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class น้มุ_3055_ลปรโ {
    static class info{
        int x;
        int y;

        public info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[][] map = new String[n][m];
        boolean[][] check = new boolean[n][m];
        Queue<info> queue = new LinkedList<>();
        Queue<info> water_queue = new LinkedList<>();
        boolean[][] water_check = new boolean[n][m];
        for(int i=0; i<n; i++){
            String[] data = br.readLine().split("");
            for(int j=0; j<data.length; j++){
                map[i][j] = data[j];
                if(data[j].equals("S")){
                    queue.add(new info(i,j));
                    check[i][j] = true;
                }
                if(data[j].equals("*")){
                    water_queue.add(new info(i,j));
                    water_check[i][j] = true;
                }
            }
        }
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int time = 0;
        int size = queue.size();
        int cnt = 0;
        while(!queue.isEmpty()){
            info temp = queue.poll();
            int temp_x = temp.x;
            int temp_y = temp.y;
            cnt++;
//            System.out.println(temp_x + " , " + temp_y + " : " + time);
            if(map[temp_x][temp_y].equals("D")){
                System.out.println(time);
                return;
            }
            if(!map[temp_x][temp_y].equals("*")) {
                for (int i = 0; i < 4; i++) {
                    int x = temp_x + dx[i];
                    int y = temp_y + dy[i];
                    if (x >= n || x < 0 || y >= m || y < 0)
                        continue;
                    if (!check[x][y]) {
                        if (map[x][y].equals(".") || map[x][y].equals("D")) {
                            queue.add(new info(x, y));
                            check[x][y] = true;
                        }
                    }
                }
            }

            if(cnt==size){
                size = queue.size();
                cnt = 0;
                time++;
                int water_cnt = 0;
                int water_size = water_queue.size();
                while (!water_queue.isEmpty()){
                    info water_temp = water_queue.poll();
                    int water_x = water_temp.x;
                    int water_y = water_temp.y;
                    for(int i=0; i<4; i++){
                        int x = water_x + dx[i];
                        int y = water_y + dy[i];
                        if(x>=n || x<0 || y>=m || y<0)
                            continue;
                        if(!water_check[x][y]){
                            if(map[x][y].equals(".") || map[x][y].equals("S")) {
                                water_queue.add(new info(x, y));
                                water_check[x][y] = true;
                                map[x][y] = "*";
                            }
                        }
                    }
                    water_cnt++;
                    if(water_cnt == water_size){
                        break;
                    }
                }
//                for(int i=0; i<n; i++){
//                    for(int j=0; j<map[0].length; j++){
//                        System.out.print(map[i][j]);
//                    }
//                    System.out.println();
//                }
            }
        }
        System.out.println("KAKTUS");
    }
}
