package CodingTest.īī��2020���Ͻ�;

/**
 * �ش� ������ �湮�ϰ� �Ǵ� ���⿡ ���� cost�� �ٸ���.
 * 2���� �迭�� �ϸ� ���ܰ� ����Ƿ� 3�����迭�� ������ Ȯ���ϸ鼭 cost�� �ľ��Ѵ�.
 */


public class ���ַΰǼ� {
    static int answer=Integer.MAX_VALUE;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int[][][] money;
    public static void main(String[] args) {
        int[][] board = {{0, 0, 1, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 1, 0, 0, 1, 0, 0, 0, 1, 0},
                {1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0}};
        for (int i = 0; i < board.length; i++) {
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(solution(board));
    }
    public static int solution(int[][] board){
        money = new int[board.length][board[0].length][4];
        money[0][0][0] = -1;
        money[0][0][1] = -1;
        money[0][0][2] = -1;
        money[0][0][3] = -1;
        search(board,0,0,-1,-500);
        return answer;
    }
    public static void search(int[][] board, int x, int y, int way, int cost){
        if(x==board.length-1 && y==board[0].length-1){
            answer = Math.min(answer, cost);
            return;
        }
        if(way!=-1) {
            if (money[x][y][way] != 0)
                if (money[x][y][way] < cost)
                    return;
            money[x][y][way] = cost;
        }
        for (int i = 0; i < 4; i++) {
            int tempx = x + dx[i];
            int tempy = y + dy[i];
            if (!checkRange(board, tempx, tempy))
                continue;
            if (board[tempx][tempy]==0){
                if(way==i){
                    search(board, tempx, tempy, way, cost+100);
                }else{
                    search(board, tempx, tempy, i, cost+600);
                }
            }
        }
    }
    public static boolean checkRange(int[][] board, int x, int y){
        if(x<0 || x>=board.length || y<0 || y>=board[0].length)
            return false;
        return true;
    }
}
