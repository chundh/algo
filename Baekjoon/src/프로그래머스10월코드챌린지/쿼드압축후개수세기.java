package 프로그래머스10월코드챌린지;

public class 쿼드압축후개수세기 {
    static int cnt_z=0;
    static int cnt_one = 0;
    public static void main(String[] args) {
        int[][] arr = {{1,1,1,1,1,1,1,1}, {0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
        solution(arr);
    }
    public static void solution(int[][] arr){
        recur(arr, 0, 0, arr.length);
        System.out.println(cnt_z + " , " + cnt_one);
    }
    public static void recur(int[][] arr, int x, int y, int len){
        if(len==1){
            if(arr[x][y]==0){
                cnt_z++;
            }else{
                cnt_one++;
            }
            return;
        }
        int d = arr[x][y];
        int flag=0;
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(arr[x+i][y+j] != d){
                    flag=1;
                    break;
                }
            }
            if(flag==1){
                break;
            }
        }
        if(flag==0){
            if(d==0){
                cnt_z++;
            }else{
                cnt_one++;
            }
            return;
        }
        int n_len = len/2;
        recur(arr, x,y, n_len);
        recur(arr, x+n_len, y, n_len);
        recur(arr, x, y+n_len, n_len);
        recur(arr, x+n_len, y+n_len, n_len);
    }
}
