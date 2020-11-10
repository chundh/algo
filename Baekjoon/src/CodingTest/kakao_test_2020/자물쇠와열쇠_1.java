package CodingTest.kakao_test_2020;

import java.util.ArrayList;
import java.util.Collection;

public class 자물쇠와열쇠_1 {
    static boolean answer = false;
    static ArrayList<p> key_point;
    static ArrayList<p> lock_point;
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        solution(key, lock);
    }

    public static void solution(int[][] key, int[][] lock){
        int m = key.length;
        int n = lock.length;
        int[][] turnkey1 = new int[key.length][key[0].length]; // 90도 회전
        int[][] turnkey2 = new int[key.length][key[0].length]; // 180도 회전
        int[][] turnkey3 = new int[key.length][key[0].length]; // 270도 회전
        key_point = new ArrayList<p>();
        lock_point = new ArrayList<p>();
        for(int j=0; j<key.length; j++) {
            for(int i=0; i<key.length; i++) {
                turnkey1[j][i] = key[key.length-i-1][j];
                if(lock[j][i] == 0) {
                    p po = new p(j,i);
                    lock_point.add(po);
                }
                if(turnkey1[j][i] == 1) {
                    p po = new p(j,i);
                    key_point.add(po);
                }
            }
        }
        for(int i=0; i<lock_point.size(); i++){
            System.out.println(lock_point.get(i).x +" , " + lock_point.get(i).y);
        }
        System.out.println("90도 회전 후 시작");
        check(key, lock, 0, 0);
        if(answer) {
            System.out.println("success");
            return;
        }
        key_point.clear();
        for(int j=0; j<key.length; j++) {
            for(int i=0; i<key.length; i++) {
                turnkey2[j][i] = turnkey1[key.length-i-1][j];
                if(turnkey2[j][i] == 1) {
                    p po = new p(j,i);
                    key_point.add(po);
                }
            }
        }
        System.out.println("180도 회전 후 시작");
        check(key, lock, 0, 0);
        if(answer) {
            System.out.println("success");
            return;
        }
        key_point.clear();
        for(int j=0; j<key.length; j++) {
            for(int i=0; i<key.length; i++) {
                turnkey3[j][i] = turnkey2[key.length-i-1][j];
                if(turnkey3[j][i] == 1) {
                    p po = new p(j,i);
                    key_point.add(po);
                }
            }
        }
        System.out.println("270도 회전 후 시작");
        check(key, lock, 0, 0);
        if(answer) {
            System.out.println("success");
            return;
        }
        key_point.clear();
        for(int j=0; j<key.length; j++) {
            for(int i=0; i<key.length; i++) {
                if(key[j][i] == 1) {
                    p po = new p(j,i);
                    key_point.add(po);
                }
            }
        }
        System.out.println("0도 회전 후 시작");
        check(key, lock, 0, 0);
        if(answer) {
            System.out.println("success");
            return;
        }
        System.out.println("Fail");
    }
    /**
     * 회전된 함수마다 위치 옮기면서 구멍에 맞는지 확인해야함.
     * 해당 위치에서 오른쪽으로 쭉 밀어보고 key[0].length번 밀고나서
     * x+1 후 다시 key[0].length만큼 미는 방식으로 x가 x.length가 될때까지 진행
     */
    public static void check(int[][] key, int[][] lock, int x, int y){
        if(x==key.length-1 && y == key[0].length){
            return;
        }
        if(y==key[0].length){
            x++;
            y=0;
            check(key, lock, x, y);
            return;
        }
        ArrayList<p> new_key_point = new ArrayList<>();
        // 현재 위치에서 구멍과 맞는지 확인해야한다.
        for(int i=0; i<key_point.size(); i++){
            new_key_point.add(new p(key_point.get(i).x+x, key_point.get(i).y+y));
        }
        for(int i=0; i<new_key_point.size(); i++){
            System.out.println(new_key_point.get(i).x + " , " + new_key_point.get(i).y);
        }
        if(new_key_point.containsAll(lock_point)){
            System.out.println("성공");
            answer = true;
            return;
        }
        else{
            y++;
            check(key, lock, x, y);
        }
    }
}
class p extends ArrayList {
    int x;
    int y;
    public p(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean containsAll(Collection c) {
        return super.containsAll(c);
    }
}

