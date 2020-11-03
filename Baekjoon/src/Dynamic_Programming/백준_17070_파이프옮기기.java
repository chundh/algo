package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ����_17070_�������ű�� {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+2][n+2];
        for(int i=1; i<=n; i++){
            String[] data = br.readLine().split(" ");
            for(int j=1; j<=data.length; j++){
                arr[i][j] = Integer.parseInt(data[j-1]);
            }
        }
        int[][][] map = new int[n+2][n+2][3]; // 0: ���� 1: ���� 2: �밢��
        map[1][2][0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=0; k<3; k++){
                    if(map[i][j][k]!=0){
                        if(k==0){
                            if(arr[i][j+1]!=1)
                                map[i][j+1][k] += map[i][j][k];
                            if(arr[i+1][j+1]!=1 && arr[i+1][j]!=1 && arr[i][j+1] != 1)
                                map[i+1][j+1][2] += map[i][j][k];
                        }else if(k==1){
                            if(arr[i+1][j]!=1)
                                map[i+1][j][k] += map[i][j][k];
                            if(arr[i+1][j+1]!=1 && arr[i+1][j]!=1 && arr[i][j+1] != 1)
                                map[i+1][j+1][2] += map[i][j][k];
                        }else{
                            if(arr[i][j+1]!=1)
                                map[i][j+1][0] += map[i][j][k];
                            if(arr[i+1][j]!=1)
                                map[i+1][j][1] += map[i][j][k];
                            if(arr[i+1][j+1]!=1 && arr[i+1][j]!=1 && arr[i][j+1] != 1)
                                map[i+1][j+1][2] += map[i][j][k];
                        }
                    }
                }
            }
        }
        int answer = map[n][n][0] + map[n][n][1] + map[n][n][2];
        System.out.println(answer);
    }
}
