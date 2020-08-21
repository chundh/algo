package SCPC_6_minor;

import java.util.Scanner;

public class Ladder {
    static int num = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
            int Answer = 0;
            int n = sc.nextInt();
            int k = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[k][2];
            for(int i=0; i<k; i++){
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            int[][] data = new int[m][2];
            for(int i=0; i<m; i++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                data[i][0] = start;
                data[i][1] = end;
            }
            for(int i=0; i<m; i++){
                int start = data[i][0];
                int end = data[i][1];
                solution(arr, start, end, 0, 0);
                Answer += num;
                num = -1;
            }

            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }
    }

    public static void solution(int[][] arr, int start, int end, int index, int cnt){
        if(index==arr.length){
            if(start == end) {
                //System.out.println(start + " , " + cnt);
                if (num == -1 || num > cnt)
                    num = cnt;
            }
            return;
        }
        for(int i=index; i<arr.length; i++){
            if(arr[i][0]==start){
                //System.out.println(start + " ; " + arr[i][0] + " , " + arr[i][1] + " , " + i + " , " + cnt);
                solution(arr, arr[i][1], end,i+1, cnt);
                if(num==0)
                    return;
                cnt++;
            }
            if(arr[i][1]==start){
                //System.out.println(start + " : " + arr[i][0] + " , " + arr[i][1] + " , " + i + " , " + cnt);
                solution(arr, arr[i][0], end,i+1, cnt);
                if(num==0)
                    return;
                cnt++;
            }
        }
        if(start == end){
            if(num==-1 || num>cnt){
                num = cnt;
            }
        }
    }
}
