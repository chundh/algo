package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ¹éÁØ_2174_·Îº¿½Ã¹Ä·¹ÀÌ¼Ç {
    static class robot{
        int x;
        int y;
        int way_idx = 0;
        int[] dx = {0,1,0,-1}; // µ¿->³²->¼­->ºÏ
        int[] dy = {1,0,-1,0};

        public robot(int x, int y, int way_idx) {
            this.x = x;
            this.y = y;
            this.way_idx = way_idx;
        }
        public void go(){
            this.x += dx[this.way_idx];
            this.y += dy[this.way_idx];
        }
        public void left(){
            this.way_idx--;
            if(this.way_idx<0)
                this.way_idx=3;
        }
        public void right(){
            this.way_idx++;
            this.way_idx %= 4;
        }
    }
    static int crash_idx = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        robot[] robot = new robot[n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String way = st.nextToken();
            int num = 0;
            if(way.equals("E")){
                num = 0;
            }else if(way.equals("W")){
                num = 2;
            }else if(way.equals("S")){
                num = 1;
            }else{
                num = 3;
            }
            robot[i] = new robot(y,x,num);
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String opt = st.nextToken();
            int recur = Integer.parseInt(st.nextToken());
            if(opt.equals("L")){
                for(int j=0; j<recur; j++) {
                    robot[num].left();
                }
            }else if(opt.equals("R")){
                for(int j=0; j<recur; j++) {
                   robot[num].right();
                }
            }else if(opt.equals("F")){
                for(int j=0; j<recur; j++){
                    robot[num].go();
                    if(robot[num].x>b || robot[num].x<0 || robot[num].y>a || robot[num].y<0){
                        System.out.println(robot[num].x + " , " + robot[num].y);
                        System.out.println("Robot " + num + " crashes into the wall");
                        return;
                    }
                    if(check(robot, num)){
                        System.out.println("Robot " + num + " crashes into robot " + crash_idx);
                    }
                }
            }
            System.out.println(robot[num].x + " , " + robot[num].y + " :" + robot[num].way_idx);
        }
    }
    static boolean check(robot[] robot, int num){
        for(int i=1; i<robot.length; i++){
            if(num!=i){
                if(robot[i].x == robot[num].x && robot[i].y == robot[num].y){
                    crash_idx = i;
                    return true;
                }
            }
        }
        return false;
    }
}
/*
5 4
2 4
1 1 E
5 4 W
2 R 1
2 F 3
2 L 1
2 F 4

 */