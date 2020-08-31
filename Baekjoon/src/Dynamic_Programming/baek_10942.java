package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class baek_10942 {
    static int[] arr;
    static int[][] data;
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        int n = sc.nextInt();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
//            arr[i] = sc.nextInt();
            arr[i] = Integer.parseInt(st.nextToken());
        }
        data = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=i; j<=n; j++){
                data[i][j] = solution(i, j);
            }
        }

//        int m = sc.nextInt();
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
//            int s = sc.nextInt();
//            int e = sc.nextInt();
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
//            System.out.println(data[s][e]-1);
            sb.append(data[s][e]-1 + "\n");
        }
        System.out.println(sb.toString());
    }
    public static int solution(int s, int e){
        if(s==e) {
            return 2;
        }
        if(e-s == 1){
            if(arr[s]==arr[e]) {
                return 2;
            }
            else {
                return 1;
            }
        }
        if(data[s][e] >=1){
            return data[s][e];
        }
        if(arr[s]!=arr[e])
            return 1;
        return data[s][e] = solution(s+1, e-1);
    }
}
