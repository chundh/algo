package ½Ã¹Ä·¹ÀÌ¼Ç;

import java.util.Scanner;

public class ¹éÁØ_15683_°¨½Ã {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] >=1 && arr[i][j]<=5){
                    int left=0;
                    int right=0;
                    int top =0;
                    int bottom=0;
                    int flag=0;
                    int max=0;
                    for(int k=j-1; k>=0; k--){ // ¿ÞÂÊ °¹¼ö ÆÄ¾Ç
                        if(arr[i][k]==0){
                            left++;
                        }else if(arr[i][k]==6)
                            break;
                    }
                    max = left;
                    flag = 1;
                    for(int k=j+1; k<m; k++){ // ¿À¸¥ÂÊ °¹¼ö ÆÄ¾Ç
                        if(arr[i][k]==0){
                            right++;
                        }else if(arr[i][k]==6){
                            break;
                        }
                    }
                    if(right>left){
                        flag=2;
                        max = right;
                    }
                    for(int k=i-1; k>=0; k--){ // À§ÂÊ °¹¼ö ÆÄ¾Ç
                        if(arr[k][j]==0){
                            top++;
                        }else if(arr[k][j]==6){
                            break;
                        }
                    }
                    if(top>max){
                        max = top;
                        flag= 3;
                    }
                    for(int k=i+1; k<n; k++){ // ¾Æ·¡ÂÊ °¹¼ö ÆÄ¾Ç
                        if(arr[k][j]==0){
                            bottom++;
                        }else if(arr[k][j]==6){
                            break;
                        }
                    }
                    if(bottom>max){
                        max = bottom;
                        flag = 4;
                    }
                    if(arr[i][j]==1){
                        fill(arr, i, j, flag);
                    }else if(arr[i][j] == 2){
                        int f = 0;
                        if(left+right > top+bottom){
                            f=1;
                        }else
                            f=2;
                        if(f==1){
                            fill(arr, i, j, 1);
                            fill(arr, i, j, 2);
                        }
                    }else if(arr[i][j]==3){
                        int f=0;
                        if(left+top > left+bottom){
                            f=1;
                        }else{
                            f=2;
                        }
                        if(right+top > right+bottom){
                            if(f==1){
                                if(right+top>left+top)
                                    f=3;
                            }else{
                                if(right+top > left+bottom)
                                    f=3;
                            }
                        }else{
                            if(f==1){
                                if(right+bottom>left+top)
                                    f=3;
                            }else{
                                if(right+bottom > left+bottom)
                                    f=3;
                            }
                        }
                        if(f==1){
                            fill(arr, i, j, 1);
                            fill(arr, i, j, 3);
                        }else if(f==2){
                            fill(arr, i, j, 1);
                            fill(arr, i, j, 4);
                        }else if(f==3){
                            fill(arr, i, j, 2);
                            fill(arr, i, j, 3);
                        }else{
                            fill(arr, i, j, 2);
                            fill(arr, i, j, 4);
                        }
                    }else if(arr[i][j]==4){
                        int f=0;
                        if(left<right)
                            f=1;
                        else
                            f=2;
                        if(top<bottom){
                            if(f==1){
                                if(top<left)
                                    f=3;
                            }
                            else{
                                if(top<right)
                                    f=3;
                            }
                        }else{
                            if(f==1){
                                if(bottom<left)
                                    f=4;
                            }
                            else{
                                if(bottom<right)
                                    f=4;
                            }
                        }
                        for(int a=1; a<=4; a++){
                            if(a==f)
                                continue;
                            fill(arr, i, j, a);
                        }
                    }else{
                        for(int a=1; a<=4; a++){
                            fill(arr, i, j, a);
                        }
                    }
                }
            }
        }
        int answer=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 0){
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static void fill(int[][] arr, int x, int y, int flag){
        if(flag==1){ // ¿ÞÂÊÀ¸·Î Ä¥ÇÏ±â
            for(int i=y-1; i>=0; i--){
                if(arr[x][i]==6){
                    break;
                }else if(arr[x][i]==0)
                    arr[x][i] = 7;
            }
        }else if(flag==2){ // ¿À¸¥ÂÊÀ¸·Î Ä¥ÇÏ±â
            for(int i=y+1; i<arr[x].length; i++){
                if(arr[x][i]==6){
                    break;
                }else if(arr[x][i]==0)
                    arr[x][i] = 7;
            }
        }else if(flag==3){ // À§·ÎÄ¥ÇÏ±â
            for(int i=x-1; i>=0; i--){
                if(arr[i][y] ==6)
                    break;
                else if(arr[i][y]==0)
                    arr[i][y] = 7;
            }
        }else{ // ¾Æ·¡·Î Ä¥ÇÏ±â
            for(int i=x+1; i<arr.length; i++){
                if(arr[i][y] ==6)
                    break;
                else if(arr[i][y]==0)
                    arr[i][y] = 7;
            }
        }
    }
}
