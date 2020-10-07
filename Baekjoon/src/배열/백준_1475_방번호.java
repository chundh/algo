package 배열;

import java.io.*;

public class 백준_1475_방번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String data = br.readLine();
        int[][] arr = new int[7][10];
        int max_idx = 0;
        int answer=0;
        for(int i=0; i<data.length(); i++){
            int temp = Integer.parseInt(data.substring(i,i+1));
            if(temp == 6 || temp == 9){
                int flag=0;
                for(int j=0; j<=max_idx; j++){
                    if(arr[j][6] == 0){
                        arr[j][6] = 1;
                        flag=1;
                        break;
                    }else if(arr[j][9] == 0){
                        arr[j][9] = 1;
                        flag=1;
                        break;
                    }
                }
                if(flag==0){
                    max_idx++;
                    arr[max_idx][temp] = 1;
                }
                continue;
            }
            int flag = 0;
            for(int j=0; j<=max_idx; j++){
                if(arr[j][temp] == 0){
                    arr[j][temp] = 1;
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                max_idx++;
                arr[max_idx][temp] = 1;
            }
        }
        System.out.println(max_idx+1);
    }
}
