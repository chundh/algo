package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1062_가르침 {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] learn = new int[27];
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine();
        }
        if(k<5){
            System.out.println(0);
            return;
        }else{
            learn['a'-97] = 1;
            learn['n'-97] = 1;
            learn['t'-97] = 1;
            learn['i'-97] = 1;
            learn['c'-97] = 1;
            int cnt = 5;
            back(learn, arr, cnt, k, 0);
            System.out.println(answer);
        }
    }
    public static void back(int[] learn, String[] arr, int cnt, int k, int idx){
        if(cnt==k){
            int temp = 0;
            for(int i=0; i<arr.length; i++){
                int flag = 0;
                for(int j=4; j<arr[i].length()-4; j++){
                    if(learn[arr[i].charAt(j)-97]==0){
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                    temp++;
            }
            answer = Math.max(answer, temp);
            return;
        }
        for(int i=idx; i<27; i++){
            if(learn[i] == 1)
                continue;
            learn[i] = 1;
            back(learn, arr, cnt+1, k, i+1);
            learn[i] = 0;
        }
    }
}