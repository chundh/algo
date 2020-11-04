package Summer_Winter_Coding;

public class 방문길이 {
    static class mapStatus{
        boolean left;
        boolean right;
        boolean up;
        boolean down;

        public mapStatus(boolean left, boolean right, boolean up, boolean down) {
            this.left = left;
            this.right = right;
            this.up = up;
            this.down = down;
        }
    }
    public static void main(String[] args) {
        String dirs = "LULLLLLLU";
        System.out.println(solution(dirs));
    }
    public static int solution(String dirs){
        mapStatus[][] map = new mapStatus[11][11];
        int x = 5;
        int y = 5;
        int answer = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j=0; j< map.length; j++){
                map[i][j] = new mapStatus(false, false, false, false);
            }
        }
        for (int i = 0; i < dirs.length(); i++) {
            String opt = String.valueOf(dirs.charAt(i));
            mapStatus temp = map[x][y];
            if(opt.equals("U")){
                if(checkRange(x-1, y)) {
                    if (!temp.up) {
                        answer++;
                        temp.up = true;
                        map[x - 1][y].down = true;
                    }
                    x--;
                }
            }else if(opt.equals("D")){
                if(checkRange(x+1, y)){
                    if(!temp.down){
                        answer++;
                        temp.down = true;
                        map[x+1][y].up = true;
                    }
                    x++;
                }
            }else if(opt.equals("R")){
                if (checkRange(x, y+1)){
                    if (!temp.right) {
                        answer++;
                        temp.right = true;
                        map[x][y + 1].left = true;
                    }
                    y++;
                }
            }else if(opt.equals("L")){
                if (checkRange(x, y-1)){
                    if (!temp.left){
                        answer++;
                        temp.left=true;
                        map[x][y-1].right = true;
                    }
                    y--;
                }
            }
        }
        return answer;
    }
    public static boolean checkRange(int x, int y){
        if(x<0 || x>10 || y<0 || y>10)
            return false;
        return true;
    }
}
