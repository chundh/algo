package SCPC_5_minor;

import java.util.Scanner;

public class Similiar {
    static int[] arr1;
    static int[] arr2;
    static int n;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
            answer=0;
            n = sc.nextInt();
            arr1 = new int[n];
            arr2 = new int[n];
            for(int i=0; i<n; i++){
                arr1[i] = sc.nextInt();
            }
            for(int i=0; i<n; i++){
                arr2[i] = sc.nextInt();
            }
            for(int i=0; i<n; i++){
                solution(i,i+1);
            }
            System.out.println("Case #"+(test_case+1));
            System.out.println(answer);
        }
    }

    public static void solution(int start, int index){
        for(int i=index; i<n; i++){
            swap(start, i);
        }
    }
    public static void swap(int start, int end){
        int f_end = end;
        int[] temp_arr = new int[n];
        int cnt=0;
        for(int i=0; i<start; i++){
            temp_arr[i] = arr2[i];
            if(arr1[i]==temp_arr[i])
                cnt++;
        }
        if((start+end)%2==0){
            int mid = (start+end)/2;
            for(int i=start; i<mid; i++){
                temp_arr[i] = arr2[end];
                temp_arr[end] = arr2[i];
                if(arr1[end] == temp_arr[end])
                    cnt++;
                end--;
                if(arr1[i]==temp_arr[i])
                    cnt++;
            }
            temp_arr[mid] = arr2[mid];
            if(arr1[mid] == temp_arr[mid])
                cnt++;
        }
        else{
            int mid = (start+end)/2;
            for(int i=start; i<=mid; i++){
                temp_arr[i] = arr2[end];
                temp_arr[end] = arr2[i];
                if(arr1[end] == temp_arr[end])
                    cnt++;
                end--;
                if(arr1[i]==temp_arr[i])
                    cnt++;
            }
        }
        for(int i=f_end+1; i<n; i++){
            temp_arr[i] = arr2[i];
            if(temp_arr[i] == arr1[i])
                cnt++;
        }
        if(answer<cnt) {
            answer = cnt;
        }else{
            if(f_end==n-1)
                n--;
        }
    }
}
