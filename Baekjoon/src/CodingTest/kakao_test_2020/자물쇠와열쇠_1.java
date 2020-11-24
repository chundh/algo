package CodingTest.kakao_test_2020;

import java.util.ArrayList;

public class 자물쇠와열쇠_1 {
    static boolean answer = false;
    static int size = 0;
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        solution(key, lock);
    }

    public static void solution(int[][] key, int[][] lock) {
        int[][] board = new int[key.length*2 + lock.length][key.length*2 + lock.length];
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                board[i+key.length][j+ key.length] = lock[i][j];
                if(lock[i][j] == 0){
                    board[i+key.length][j+key.length] = 2;
                    size++;
                }
            }
        }
        for(int test_case = 0; test_case<4; test_case++) {
            answer = move(key, board);
            if(answer)
                break;
            key = turnKey(key);
        }
        System.out.println(answer);
    }

    // 시계방향으로 90도 회전
    public static int[][] turnKey(int[][] key){
        int[][] board = new int[key.length][key[0].length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[0].length; j++) {
                board[i][j] = key[key.length-1-j][i];
            }
        }
        return board;
    }
    public static boolean move(int[][] key, int[][] board) {
        for (int i = 0; i < board.length-key.length; i++) {
            for (int j = 0; j < board.length-key.length; j++) {
                boolean temp = check(key, board, i, j);
                if(temp){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean check(int[][] key, int[][] board, int x, int y){
        int cnt = 0;
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                if (key[i][j] == 1 && board[i+x][j+y]==1){ // 돌기에 걸리는 경우
                    return false;
                }else if(key[i][j] == 1 && board[i+x][j+y]==2){
                    cnt++;
                }
            }
        }
        if(cnt==size)
            return true;
        return false;
    }
}

