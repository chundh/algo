package Greedy;

import java.util.Scanner;

public class ����_11047_����0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int answer = 0;
        for(int i=n-1; i>=0; i--){
            if(k==0){
                break;
            }
            if(k>=arr[i]){
                answer++;
                k-=arr[i];
                i++;
            }
        }
        System.out.println(answer);
    }
}
