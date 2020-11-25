package CodingTest.kakao_test_2020;

import java.util.LinkedList;
import java.util.Queue;

public class 블록이동하기 {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static class point{
        int x;
        int y;
        int opt; // 0은 가로 1은 세로
        int time;
        public point(int x, int y, int opt, int time) {
            this.x = x;
            this.y = y;
            this.opt = opt;
            this.time = time;
        }
        public boolean rotateRowDown(int[][] board){ // 가로를 세로로
            if(x>=board.length-1 || y>=board.length-1)
                return false;
            if(board[x+1][y] == 0 && board[x+1][y+1]==0)
                return true;
            return false;
        }
        public boolean rotateRowUp(int[][] board){ // 가로를 세로로
            if(x<=0 || y>=board.length-1)
                return false;
            if(board[x-1][y] == 0 && board[x-1][y+1]==0)
                return true;
            return false;
        }
        public boolean rotateColDown(int[][] board){
            if(x>=board.length-1 || y>=board.length-1)
                return false;
            if(board[x][y+1] == 0 && board[x+1][y+1]==0)
                return true;
            return false;
        }
        public boolean rotateColUp(int[][] board){
            if(y<=0 || x>=board.length-1)
                return false;
            if(board[x][y-1] == 0 && board[x+1][y-1]==0)
                return true;
            return false;
        }
    }
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1, 1}, {0, 0, 1, 0, 0, 0, 0}};
        블록이동하기 a = new 블록이동하기();
        a.solution(board);
    }
    public int solution(int[][] board){
        int answer = 0;
        point d = new point(0,0, 0,0);
        Queue<point> queue = new LinkedList<>();
        queue.add(d);
        boolean[][][] visit = new boolean[board.length][board[0].length][2];
        while(!queue.isEmpty()){
            point temp = queue.poll();
            if(temp.opt==0){
                if(temp.x==board.length-1 && temp.y+1 == board.length-1){
                    answer = temp.time;
                    break;
                }
                if(temp.x==board.length-1 && temp.y == board.length-1){
                    answer = temp.time;
                    break;
                }
            }else{
                if(temp.x+1==board.length-1 && temp.y == board.length-1){
                    answer = temp.time;
                    break;
                }
                if(temp.x==board.length-1 && temp.y == board.length-1){
                    answer = temp.time;
                    break;
                }
            }
            if(visit[temp.x][temp.y][temp.opt])
                continue;
            visit[temp.x][temp.y][temp.opt] = true;
//            System.out.println(temp.x + " , " + temp.y + " : " + temp.opt + " : " +temp.time);
            for (int i = 0; i < 4; i++) {
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                if(checkRange(board, x, y, temp.opt)){
                    queue.add(new point(x,y,temp.opt, temp.time+1));
                }else{
                    if(x<0 || y<0 || x>=board.length || y>=board.length)
                        continue;
                    if(temp.opt==0){
                        if(temp.rotateRowDown(board)){
                            queue.add(new point(temp.x, temp.y+1, 1, temp.time+1));
                        }
                        if(temp.rotateRowUp(board)){
                            queue.add(new point(temp.x-1, temp.y+1, 1, temp.time+1));
                        }
                    }else{
                        if(temp.rotateColDown(board)){
                            queue.add(new point(temp.x+1, temp.y, 0, temp.time+1));
                        }
                        if(temp.rotateColUp(board)){
                            queue.add(new point(temp.x+1, temp.y-1, 0, temp.time+1));
                        }
                    }
                }
            }
        }
        System.out.println(answer);
        return answer;
    }
    public boolean checkRange(int[][] board, int x, int y, int opt){
        int ex, ey;
        if(opt == 0){
            ex = x;
            ey = y+1;
        }else{
            ex = x+1;
            ey = y;
        }
        if(x<0 || x>=board.length || y<0 || y>=board.length)
            return false;
        if(ex<0 || ex>=board.length || ey<0 || ey>=board.length)
            return false;
        if(board[x][y] == 0 && board[ex][ey]==0){
            return true;
        }
        return false;
    }
}

//{{0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1, 1}, {0, 0, 1, 0, 0, 0, 0}