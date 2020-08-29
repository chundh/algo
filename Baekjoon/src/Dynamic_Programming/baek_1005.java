package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class baek_1005 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        int t = sc.nextInt();
        int t = Integer.parseInt(br.readLine());
        for(int tc=0; tc<t; tc++){
//            int n = sc.nextInt();
//            int k = sc.nextInt();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr= new int[n+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){

//                arr[i] = sc.nextInt();
                arr[i] = Integer.parseInt(st.nextToken());
            }
            data[] data = new data[n+1];
            for(int i=1; i<n+1; i++){
                data[i] = new data();
            }
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
//                int ver = sc.nextInt();
//                int node = sc.nextInt();
                int ver = Integer.parseInt(st.nextToken());
                int node = Integer.parseInt(st.nextToken());
                data[node].arr.add(ver);
            }
//            int obj = sc.nextInt();
            int obj = Integer.parseInt(br.readLine());
            int[] check = new int[n+1];
            System.out.println(solution(arr, check, data, obj));
        }
    }

    public static int solution(int[] arr, int[] check, data[] data, int node){
        if(check[node]!=0)
            return check[node];
        if(data[node].arr.size()==0){
            check[node] = arr[node];
            return arr[node];
        }
        int time = 0;
        for(int i=0; i<data[node].arr.size(); i++){
            int temp = solution(arr, check, data, data[node].arr.get(i));
            if(temp>time)
                time = temp;
        }
        time+=arr[node];
        check[node] = time;
        return time;
    }
}

class data{
    ArrayList<Integer> arr;
    public data(){
        this.arr = new ArrayList<>();
    }
}