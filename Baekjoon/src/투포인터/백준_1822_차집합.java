package 투포인터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 백준_1822_차집합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int na = sc.nextInt();
        int nb = sc.nextInt();
        int[] a = new int[na];
        int[] b = new int[nb];
        for(int i=0; i<na; i++){
            a[i] = sc.nextInt();
        }
        for(int i=0; i<nb; i++){
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int a_idx=0;
        int b_idx=0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(true){
            if(b_idx==nb || a_idx==na){
                break;
            }
            if(a[a_idx]<b[b_idx]){
                arr.add(a[a_idx]);
                a_idx++;
            }else if(a[a_idx]>b[b_idx]){
                b_idx++;
            }else{
                a_idx++;
                b_idx++;
            }
        }
        if(a_idx!=na){
            for(int i=a_idx; i<na; i++){
                arr.add(a[i]);
            }
        }
        System.out.println(arr.size());
        for(int i=0; i<arr.size(); i++){
            System.out.print(arr.get(i) + " ");
        }
    }
}
