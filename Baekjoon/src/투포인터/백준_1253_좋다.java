package 투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_1253_좋다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int answer = 0;
        for(int i=0; i<n; i++){
            int temp = arr[i];
            int left = 0;
            int right = n-1;
            while(true){
                if(left>=right)
                    break;
                int sum = arr[left] + arr[right];
                if(sum<temp){
                    left++;
                }else if(sum>temp){
                    right--;
                }else{
                    if(left!=i && right!=i) {
                        answer++;
                        break;
                    }
                    if(left==i){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
