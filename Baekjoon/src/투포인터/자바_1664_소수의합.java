package 투포인터;

import javafx.scene.effect.Blend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 자바_1664_소수의합 {
    static boolean[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new boolean[n+1];
        make(n);
        ArrayList<Integer> data = new ArrayList<>();
        if(n==1){
            System.out.println(0);
            return;
        }
        for (int i = 2; i <= n; i++) {
            if(!arr[i])
                data.add(i);
        }
        int left = 0;
        int right = 1;
        int sum = data.get(left);
        int answer = 0;
        while(true){
            if(left == data.size()-1) {
                if(sum==n)
                    answer++;
                break;
            }
            if(sum>n){
                left++;
                right = left;
                sum = 0;
            }else if(sum==n){
                answer++;
            }
            sum+=data.get(right);
            right++;
        }
        System.out.println(answer);
    }
    public static void make(int n){
        // 소수이면 false로 저장
        arr[0] = true;
        arr[1] = true;
        for(int i=2; i*i<=arr.length; i++){
            if(arr[i])
                continue;
            for(int j = i*i; j<=n; j+=i){
                arr[j] = true;
            }
        }
    }
}
