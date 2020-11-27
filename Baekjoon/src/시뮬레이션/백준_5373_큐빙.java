package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 각 면을 2차원 배열로 구성
 * 정육면체로 구성했을때, 축을 잘 잡아야한다
 * 뒷면을 잘 못 잡아서 틀린 상태
 */

public class 백준_5373_큐빙 {
    static String[][] upMap = new String[3][3];
    static String[][] downMap = new String[3][3];
    static String[][] leftMap = new String[3][3];
    static String[][] rightMap = new String[3][3];
    static String[][] frontMap = new String[3][3];
    static String[][] backMap = new String[3][3];
    public static String[][] turnMap(String[][] key){
        String[][] board = new String[key.length][key[0].length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[0].length; j++) {
                board[i][j] = key[key.length-1-j][i];
            }
        }
        return board;
    }
    public static String[][] turnMapReverse(String[][] key){
        String[][] board = new String[key.length][key[0].length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[0].length; j++) {
                board[i][j] = key[j][key.length-1-i];
            }
        }
        return board;
    }
    public static void UDRotate(String data){
        int idx;
        if(data.substring(0,1).equals("U")) idx = 0;
        else idx = 2;
        String[] save = new String[3];
        for (int i = 0; i < 3; i++) {
            save[i] = backMap[idx][i];
        }
        if(data.equals("U+") || data.equals("D-")){
            for (int i = 0; i < 3; i++) backMap[idx][2-i] = leftMap[idx][i];
            for (int i = 0; i < 3; i++) leftMap[idx][i] = frontMap[idx][i];
            for (int i = 0; i < 3; i++) frontMap[idx][i] = rightMap[idx][i];
            for (int i = 0; i < 3; i++) rightMap[idx][2-i] = save[i];
        }else{
            for (int i = 0; i < 3; i++) backMap[idx][2-i] = rightMap[idx][i];
            for (int i = 0; i < 3; i++) rightMap[idx][i] = frontMap[idx][i];
            for (int i = 0; i < 3; i++) frontMap[idx][i] = leftMap[idx][i];
            for (int i = 0; i < 3; i++) leftMap[idx][2-i] = save[i];
        }
        if(data.equals("U+")) upMap = turnMap(upMap);
        else if(data.equals("U-")) upMap = turnMapReverse(upMap);
        else if(data.equals("D+")) downMap = turnMap(downMap);
        else if(data.equals("D-")) downMap = turnMapReverse(downMap);
    }
    public static void LRRotate(String data){
        int idx;
        if(data.substring(0,1).equals("L")) idx = 0;
        else idx = 0;
        String[] save = new String[3];
        for (int i = 0; i < 3; i++) {
            save[i] = backMap[i][idx];
        }
        if(data.equals("L+") || data.equals("R-")){
            for (int i = 0; i < 3; i++) backMap[i][idx] = downMap[i][idx];
            for (int i = 0; i < 3; i++) downMap[2-i][idx] = frontMap[i][idx];
            for (int i = 0; i < 3; i++) frontMap[i][idx] = upMap[i][idx];
            for (int i = 0; i < 3; i++) upMap[2-i][idx] = save[i];
        }else{
            for (int i = 0; i < 3; i++) backMap[2-i][idx] = upMap[i][idx];
            for (int i = 0; i < 3; i++) upMap[i][idx] = frontMap[i][idx];
            for (int i = 0; i < 3; i++) frontMap[2-i][idx] = downMap[i][idx];
            for (int i = 0; i < 3; i++) downMap[i][idx] = save[i];
        }
        if(data.equals("L+")) leftMap = turnMap(leftMap);
        else if(data.equals("L-")) leftMap = turnMapReverse(leftMap);
        else if(data.equals("R+")) rightMap = turnMap(rightMap);
        else if(data.equals("R-")) rightMap = turnMapReverse(rightMap);
    }
    public static void FBRotate(String data){
        int idx;
        if(data.substring(0,1).equals("B")) idx = 0;
        else idx = 2;
        String[] save = new String[3];
        for (int i = 0; i < 3; i++) {
            save[i] = upMap[i][idx];
        }
        int temp=0;
        if(idx==0) temp = 2;
        if(data.equals("F+") || data.equals("B-")){
            for (int i = 0; i < 3; i++) upMap[idx][2-i] = leftMap[i][idx];
            for (int i = 0; i < 3; i++) leftMap[i][idx] = downMap[idx][i];
            for (int i = 0; i < 3; i++) downMap[idx][i] = rightMap[i][temp];
            for (int i = 0; i < 3; i++) rightMap[i][temp] = save[i];
        }else{
            for (int i = 0; i < 3; i++) upMap[idx][i] = rightMap[i][temp];
            for (int i = 0; i < 3; i++) rightMap[i][temp] = downMap[idx][i];
            for (int i = 0; i < 3; i++) downMap[idx][2-i] = leftMap[i][idx];
            for (int i = 0; i < 3; i++) leftMap[2-i][idx] = save[i];
        }
        if(data.equals("F+")) frontMap = turnMap(frontMap);
        else if(data.equals("F-")) frontMap = turnMapReverse(frontMap);
        else if(data.equals("B+")) backMap = turnMap(backMap);
        else if(data.equals("B-")) backMap = turnMapReverse(backMap);
    }
    public static void printMap(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(upMap[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void printMapback(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(backMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void init(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                upMap[i][j] = "w";
                downMap[i][j] = "y";
                leftMap[i][j] = "g";
                rightMap[i][j] = "b";
                frontMap[i][j] = "r";
                backMap[i][j] = "o";
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        init();
        for (int test_case = 0; test_case < tc; test_case++) {
            int n = Integer.parseInt(br.readLine());
            String[] data = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                String temp = data[i];
                String dir = temp.substring(0,1);
                if(dir.equals("U") || dir.equals("D")) UDRotate(temp);
                else if(dir.equals("L") || dir.equals("R")) LRRotate(temp);
                else if(dir.equals("F") || dir.equals("B")) FBRotate(temp);
                printMap();
                System.out.println();
                printMapback();
                System.out.println("-----");
            }
            init();
        }
    }
}
