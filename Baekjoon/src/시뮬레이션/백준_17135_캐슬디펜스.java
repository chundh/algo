package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_17135_캐슬디펜스 {
    static int n;
    static int m;
    static int d;
    static int[][] map;
    static int[][] restore;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        restore = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                restore[i][j] = map[i][j];
            }
        }
        ArrayList<Integer> in = new ArrayList<>();
        makeArc(in, 0);
        System.out.println(answer);
    }

    // 궁수를 배치하는 위치 생성
    public static void makeArc(ArrayList<Integer> arr, int idx){
        if(arr.size()==3){
            int cnt = attack(arr);
            if(answer<cnt){
                answer = cnt;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = restore[i][j];
                }
            }
            return;
        }
        for (int i = idx; i < m; i++) {
            arr.add(i);
            makeArc(arr, i+1);
            arr.remove(arr.indexOf(i));
        }
    }
    public static int attack(ArrayList<Integer> info){
        int cnt = 0;
        while(true) {
            for (int i = 0; i < info.size(); i++) {
                int[] target = distance(info.get(i));
//                System.out.println(target[0] + " , " + target[1]);
                if(target[0] == -1) {
                    System.out.println(info.get(i));
                    continue;
                }
                if (map[target[0]][target[1]] == 1)
                    cnt++;
                map[target[0]][target[1]]++;

            }
            downMap();
            if(!check())
                break;
//            print();
//            System.out.println("-----------");
        }
//        System.out.println(cnt);
        return cnt;
    }
    public static void downMap(){
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                if(map[i][j] == 1){
                    if(i==n-1){
                        map[i][j] = 0;
                        continue;
                    }
                    map[i+1][j] = 1;
                    map[i][j] = 0;
                }else if(map[i][j]>1){
                    map[i][j] = 0;
                }
            }
        }
    }
    public static int[] distance(int target){
        double ret = Integer.MAX_VALUE;
        int[] idx = new int[2];
        idx[0] = -1;
        for (int i = 0; i < m; i++) {
            for (int j = n-1; j >= 0; j--) {
                if(map[j][i] != 0){
                    double dis = calc(j, i, target);
                    if(dis<=d) {
                        if (ret > dis) {
                            ret = dis;
                            idx[0] = j;
                            idx[1] = i;
                        }
                    }
                    break;
                }
            }
        }
        return idx;
    }
    public static double calc(int x, int y, int target){
        int hei = n-x;
        int wid = target-y;
        return Math.pow(Math.pow(hei, 2) + Math.pow(wid, 2), 0.5);
    }

    public static boolean check(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1){
                    return true;
                }
            }
        }
        return false;
    }

    public static void print(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] +  " ");
            }
            System.out.println();
        }
    }
}
/*
2 7 2
0 0 1 0 1 0 1
1 0 1 0 1 0 0
 */