package CodingTest.kakao_test_2020;

import java.util.ArrayList;
import java.util.Collection;

public class �ڹ���Ϳ���_1 {
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
        int[][] turnkey1 = new int[key.length][key[0].length]; // 90�� ȸ��
        int[][] turnkey2 = new int[key.length][key[0].length]; // 180�� ȸ��
        int[][] turnkey3 = new int[key.length][key[0].length]; // 270�� ȸ��
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
        System.out.println("90�� ȸ�� �� ����");
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
        System.out.println("180�� ȸ�� �� ����");
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
        System.out.println("270�� ȸ�� �� ����");
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
        System.out.println("0�� ȸ�� �� ����");
        check(key, lock, 0, 0);
        if(answer) {
            System.out.println("success");
            return;
        }
        System.out.println("Fail");
    }
    /**
     * ȸ���� �Լ����� ��ġ �ű�鼭 ���ۿ� �´��� Ȯ���ؾ���.
     * �ش� ��ġ���� ���������� �� �о�� key[0].length�� �а���
     * x+1 �� �ٽ� key[0].length��ŭ �̴� ������� x�� x.length�� �ɶ����� ����
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
        // ���� ��ġ���� ���۰� �´��� Ȯ���ؾ��Ѵ�.
        for(int i=0; i<key_point.size(); i++){
            new_key_point.add(new p(key_point.get(i).x+x, key_point.get(i).y+y));
        }
        for(int i=0; i<new_key_point.size(); i++){
            System.out.println(new_key_point.get(i).x + " , " + new_key_point.get(i).y);
        }
        if(new_key_point.containsAll(lock_point)){
            System.out.println("����");
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

