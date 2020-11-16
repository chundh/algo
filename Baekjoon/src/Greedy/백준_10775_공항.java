package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_10775_공항 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        boolean[] visit = new boolean[g+1];
        int answer = 0;
        for (int i = 0; i < p; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(!visit[temp]){
                visit[temp] = true;
            }else{
                int flag = 0;
                for (int j = temp-1; j > 0; j--) {
                    if(!visit[j]){
                        visit[j] = true;
                        flag=1;
                        break;
                    }
                }
                if(flag==0){
                    break;
                }
            }
            answer++;
        }
        System.out.println(answer);
    }
}
/*
4
3
4
3
2
 */