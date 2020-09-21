package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class น้มุ_4179_บา {
    static String[][] J_map;
    static String[][] F_map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[][] arr = new String[n][m];
        J_map = new String[n][m];
        F_map = new String[n][m];
        Queue<spot> J_data = new LinkedList<>();
        Queue<spot> F_data = new LinkedList<>();

        for(int i=0; i<n; i++){
            String[] d = sc.next().split("");
            for(int j=0; j<d.length; j++) {
                arr[i][j] = d[j];
                J_map[i][j] = "";
                F_map[i][j] = "";
                if(arr[i][j].equals("J")){
                    J_map[i][j] = "J";
                    J_data.add(new spot(i,j));
                }else if(arr[i][j].equals("F")){
                    F_map[i][j] = "F";
                    F_data.add(new spot(i,j));
                }
            }
        }
        int[] dx = {1, 0 , -1, 0};
        int[] dy = {0, 1, 0, -1};
        int j_size = J_data.size();
        int j_cnt=0;
        int f_size = F_data.size();
        int f_cnt =0;
        int answer = 0;
        while(true){
            if(f_cnt==f_size){
                f_cnt=0;
                f_size = F_data.size();
                answer++;
                while(true){
                    if(J_data.isEmpty()){
                        System.out.println("IMPOSSIBLE");
                        return;
                    }
                    if(j_cnt==j_size){
                        j_cnt=0;
                        j_size = J_data.size();
                        break;
                    }
                    spot j_spot = J_data.poll();
                    int j_x = j_spot.x;
                    int j_y = j_spot.y;
                    for(int i=0; i<4; i++){
                        int temp_x = j_x + dx[i];
                        int temp_y = j_y + dy[i];
                        if(temp_x>=arr.length || temp_x<0 || temp_y>=arr[0].length || temp_y<0) {
                            System.out.println(answer);
                            return;
                        }
                        if(arr[temp_x][temp_y].equals(".") && !J_map[temp_x][temp_y].equals("J") && !F_map[temp_x][temp_y].equals("F")){
                            J_data.add(new spot(temp_x, temp_y));
                            J_map[temp_x][temp_y] = "J";
                        }
                    }
                    j_cnt++;
                }
            }
            if(F_data.isEmpty()){
                f_cnt = f_size;
                continue;
            }
            spot f_spot = F_data.poll();
            int f_x = f_spot.x;
            int f_y = f_spot.y;
            for(int i=0; i<4; i++){
                int temp_x = f_x + dx[i];
                int temp_y = f_y + dy[i];
                if(temp_x>=arr.length || temp_x<0 || temp_y>=arr[0].length || temp_y<0) {
                    continue;
                }
                if(!arr[temp_x][temp_y].equals("#") && !F_map[temp_x][temp_y].equals("F")){
                    F_data.add(new spot(temp_x, temp_y));
                    F_map[temp_x][temp_y] = "F";
                }
            }
            f_cnt++;
        }
    }
}
