package Dynamic_Programming;

import java.util.*;

public class baek_9465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int k=0; k<t; k++){
            int n = sc.nextInt();
            int[][] data = new int[2][n];
            d[] arr = new d[n*2];
            boolean[][] check = new boolean[2][n];
            int idx = 0;
            int c = 0;
            for(int i=0; i<n; i++){
                int num = sc.nextInt();
                data[idx][i] = num;
                d d = new d(num, idx, i);
                arr[c] = d;
                c++;
            }
            idx++;
            for(int i=0; i<n; i++){
                int num = sc.nextInt();
                data[idx][i] = num;
                d d = new d(num, idx, i);
                arr[c] = d;
                c++;
            }
            int answer = 0;
            int cnt = 0;
            idx = 0;
            Arrays.sort(arr);
            while(true){
                if(idx == n*2){
                    break;
                }
                d d = arr[idx];
                int num = d.num;
                int x = d.x;
                int y = d.y;
                if(!check[x][y]){
                    if(x == 0){
                        answer += data[x][y];
                        check[x][y] = true;
                        cnt++;
                        if (!check[x+1][y]) {
                            check[x+1][y] = true;
                            cnt++;
                        }
                        if (y != n - 1 && !check[x][y + 1]) {
                            check[x][y+1] = true;
                            cnt++;
                        }
                        if(y>0 && !check[x][y - 1]) {
                            check[x][y - 1] = true;
                            cnt++;
                        }
                    }
                    else{
                        answer += data[x][y];
                        cnt++;
                        check[x][y] = true;
                        if (!check[x-1][y]) {
                            check[x-1][y] = true;
                            cnt++;
                        }
                        if (y != n - 1 && !check[x][y + 1]) {
                            check[x][y+1] = true;
                            cnt++;
                        }
                        if(y>0 && !check[x][y - 1]) {
                            check[x][y - 1] = true;
                            cnt++;
                        }
                    }
                }
                idx++;
            }
            System.out.println(answer);
        }
    }
}

class d implements Comparable<d>{
    int num;
    int x;
    int y;
    public d(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(d o) {
        return -this.num+o.num;
    }
}